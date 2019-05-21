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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import yonko.com.retrofit.adapters.TweetsAdapter
import yonko.com.retrofit.contracts.TweetContract
import yonko.com.retrofit.models.TweetObJect.TweetPresenter
import yonko.com.retrofit.models.recipe.RecipeResponse


class MainActivity : AppCompatActivity(), TweetContract.View {

    var TAG = javaClass.simpleName
    private lateinit var mPresenter: TweetContract.Presenter
    lateinit var mAdapter: TweetsAdapter
    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mRecyclerView = recycler_view
        val mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.isNestedScrollingEnabled = false

        TweetPresenter(this)

        fab.setOnClickListener { view ->
            val input = searchField.text.toString()
            if (!TextUtils.isEmpty(input)) {
                if (input.length > 2) {
                    hideKeyboard(this, view)

                    // remove focus from edit text
                    searchField.clearFocus()

                    // show snackbar
                    Snackbar.make(view, "Loading recipes..", Snackbar.LENGTH_LONG).show()
                    showProgressBar(true)

                    // do network call
                    mPresenter.getTweets(input)


                } else Toast.makeText(this, "Input must be more than 3 characters", Toast.LENGTH_LONG).show()
            } else Toast.makeText(this, "Please enter a search term", Toast.LENGTH_LONG).show()
        }
    }

    override fun showProgressBar(showProgressBar: Boolean) {
        if (showProgressBar) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    override fun loadRecipes(recipeResponse: RecipeResponse) {

        if (recipeResponse.count > 0) {
            mRecyclerView.visibility = View.VISIBLE
            errorNoRecipeTv.visibility = View.GONE

            mAdapter = TweetsAdapter(this)
            mRecyclerView.adapter = mAdapter
            val recipes = recipeResponse.hits
            mAdapter.replaceData(recipes)
        } else {
            mRecyclerView.visibility = View.INVISIBLE
            errorNoRecipeTv.visibility = View.VISIBLE
        }

    }

    override fun setPresenter(presenter: TweetContract.Presenter) {
        mPresenter = presenter
    }

    override fun showError(error: String?) {
        showProgressBar(false)
        Snackbar.make(parentLayout, "Something went wrong : $error", Snackbar.LENGTH_LONG).show()
    }

    fun hideKeyboard(activity: Activity, viewToRemoveFrom: View?) {
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
