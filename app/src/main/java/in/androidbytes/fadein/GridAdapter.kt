package `in`.androidbytes.fadein

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.grid_item.view.*
import java.lang.Exception

class GridAdapter : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    private val picasso = Picasso.get()
    private val list = arrayListOf(
            Image("https://assets.materialup.com/uploads/b4ba6512-a80d-439f-963a-34359abf9c25/preview.jpg"),
            Image("https://assets.materialup.com/uploads/cd97974f-88c5-46b0-9dcb-f1ae2c700284/preview.png"),
            Image("https://assets.materialup.com/uploads/e0ccb7ba-2260-4554-bb83-288c54889ca3/preview.png"),
            Image("https://mir-s3-cdn-cf.behance.net/project_modules/source/009d0269861645.5b8fe4d999c74.jpg"),
            Image("https://assets.materialup.com/uploads/29207434-27f8-4731-924f-427117939365/preview.png"),
            Image("https://assets.materialup.com/uploads/b7b744e1-47b0-4695-8d9f-7e9872198068/preview.png"),
            Image("https://assets.materialup.com/uploads/6ad275c6-373c-4dfe-a777-004ac1cb93cf/preview.jpg"),
            Image("https://assets.materialup.com/uploads/7ca7d4d0-72c0-44b2-80de-e900343a71af/preview.png"),
            Image("https://assets.materialup.com/uploads/b4297230-bf86-4772-800e-627d3bf68b5b/preview.png"),
            Image("https://assets.materialup.com/uploads/c4aa8120-b05b-4ea4-8c01-be0a33f64ebd/preview.png"),
            Image("https://assets.materialup.com/uploads/bc50580a-22ef-4554-8874-e8876df388ee/preview.png")
    )

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val grayscaleView = holder.itemView.gridItem
        val image = list[position]

        if (image.hasFadedIn) {
            picasso.load(image.url)
                    .fit()
                    .into(grayscaleView)
        } else {
            image.hasFadedIn = true
            picasso.load(image.url)
                    .fit()
                    .into(grayscaleView, PicassoCallback(grayscaleView))
        }

    }

    //view holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //picasso callback
    class PicassoCallback(val grayscaleView: GrayscaleImageView) : Callback {
        override fun onSuccess() {
            grayscaleView.saturate()
        }

        override fun onError(e: Exception?) {}
    }
}