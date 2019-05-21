package yonko.com.retrofit.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.tweet_item.view.*
import yonko.com.retrofit.R
import yonko.com.retrofit.models.recipe.Hit
import kotlin.math.roundToInt


class TweetsAdapter(context: Context) :
    RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {
    private var mContext: Context = context
    private lateinit var mData: MutableList<Hit>
    private var mInflater: LayoutInflater
    private val TAG by lazy {
        javaClass.simpleName
    }

    init {
        mInflater = LayoutInflater.from(mContext)

    }

    fun replaceData(data: MutableList<Hit>) {
        mData = data
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val label: TextView = view.recipeName
        val calories: TextView = view.recipeCalorieCount
        val yieldTv: TextView = view.recipeYield
        val recipeImage: ImageView = view.recipeImageView
        val source: TextView = view.recipeSource
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsAdapter.ViewHolder {
        val view = mInflater.inflate(R.layout.tweet_item, parent, false)
        return TweetsAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: TweetsAdapter.ViewHolder, position: Int) {
        val item = mData[position]
        val recipes = item.recipe

        with(holder) {
            label.text = recipes.label
            yieldTv.text = "Feeds ${recipes.yield}"
            source.text = recipes.source
            val caloriesDouble = recipes.calories
            val round = caloriesDouble.roundToInt()
            calories.text = "Calories ${round}"
            loadImage(Uri.parse(recipes.image), recipeImage)
        }
    }

    private fun loadImage(uri: Uri, imageView: ImageView) {

        mContext.let {

            // Load image onto view
            Glide.with(it)
                .load(uri)
                .thumbnail(0.1f)

                // if load fails load placeholder image
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.food)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                )
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                })
                .into(imageView)
        }
    }
}
