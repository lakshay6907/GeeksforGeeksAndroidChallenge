package com.example.geeksforgeeksandroidchallenge.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.geeksforgeeksandroidchallenge.Data.Article
import com.example.geeksforgeeksandroidchallenge.Viewholder.Viewholder1
import com.example.geeksforgeeksandroidchallenge.Viewholder.Viewholder2
import com.example.geeksforgeeksandroidchallenge.databinding.ItemList1Binding
import com.example.geeksforgeeksandroidchallenge.databinding.ItemListRestBinding

class ItemAdapter(
    private val context: Context,
    private val dataset1: List<Article>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FIRST_VIEW -> Viewholder1(ItemList1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
            SECOND_VIEW -> Viewholder2(ItemListRestBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid argument type")
        }
    }

    override fun getItemCount(): Int {
        return dataset1.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            FIRST_VIEW -> {
                val item = dataset1[0]
                val viewHolder = holder as Viewholder1

                item.let {
                    // Load the image as an enclosure using Coil
                    setImage(context, it.enclosure.thumbnail, viewHolder.ImageView)

                    // Set the title and pubdate
                    viewHolder.titleView.text = it.title
                    viewHolder.pubdateView.text = it.pubDate
                }
            }
            SECOND_VIEW -> {
                val item = dataset1[position]
                val viewHolder = holder as Viewholder2

                item.let {
                    // Load the image as an enclosure using Coil

                    setImage(context, it.thumbnail, viewHolder.ImageView)

                    // Set the title and pubdate
                    viewHolder.titleView.text = it.title
                    viewHolder.pubdateView.text = it.pubDate
                }
            }
        }
    }

    private fun setImage(context: Context, thumbnail: String, imageView: ImageView) {
        val request = ImageRequest.Builder(context)
            .data(thumbnail) // Assuming thumbnail is the URL string
            .target(imageView)
            .build()
        val imageLoader = ImageLoader.Builder(context)
            .build()
        imageLoader.enqueue(request)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            FIRST_VIEW
        } else {
            SECOND_VIEW
        }
    }
}