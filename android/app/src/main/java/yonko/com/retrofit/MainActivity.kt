package yonko.com.retrofit

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import yonko.com.retrofit.contracts.TweetContract
import java.util.*

class MainActivity : AppCompatActivity(), TweetContract.View {

    var TAG = javaClass.simpleName
    private lateinit var mPresenter: TweetContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        TweetPresenter(this)

        fab.setOnClickListener { view ->

            val input = nameField.text.toString()
            val input2 = nameField2.text.toString()
            val input3 = nameField3.text.toString()

            var randomResult = ""
            if (!TextUtils.isEmpty(input) && !TextUtils.isEmpty(input2) && !TextUtils.isEmpty(input3)) {
                showProgressBar(true)
                // pick a random number between 1 and 3
                val min = 1
                val max = 3

                val random = Random().nextInt(max - min + 1) + min
                if (input.length > 2) {
                    hideKeyboard(this, view)

                    // remove focus from edit text
                    nameField.clearFocus()

                    // display the name chosen
                    when (random) {
                        1 -> randomResult = input

                        2 -> randomResult = input2

                        3 -> randomResult = input3
                    }

                    result.text = randomResult
                    // show snackbar
                    Snackbar.make(view, "And the winner is $randomResult", Snackbar.LENGTH_LONG).show()

                    // do network call
                    mPresenter.sendName(randomResult)

                } else Toast.makeText(this, "Input must be more than 3 characters", Toast.LENGTH_LONG).show()
            } else Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show()
        }
    }

    private fun showProgressBar(showProgressBar: Boolean) {
        if (showProgressBar) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    override fun success() {
        showProgressBar(false)
        Snackbar.make(parentLayout, "Success", Snackbar.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: TweetContract.Presenter) {
        mPresenter = presenter
    }

    override fun showError(error: String?) {
        showProgressBar(false)
        Snackbar.make(parentLayout, "Something went wrong : $error", Snackbar.LENGTH_LONG).show()
    }

    private fun hideKeyboard(activity: Activity, viewToRemoveFrom: View?) {
        try {
            activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
            val manager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            if (activity.currentFocus != null && activity.currentFocus!!.windowToken != null) {
                manager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
            }
            if (viewToRemoveFrom != null && viewToRemoveFrom.windowToken != null) {
                manager.hideSoftInputFromWindow(viewToRemoveFrom.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
            }
            if (viewToRemoveFrom == null) {
                val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

                // if the keyboard is showing
                if (imm.isAcceptingText) {
                    // hide the keyboard
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "************ error hiding keyboard")
        }

    }
}
