package com.example.geeksforgeeksandroidchallenge.Viewholder

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geeksforgeeksandroidchallenge.databinding.ItemListRestBinding

class Viewholder2(val binding: ItemListRestBinding):RecyclerView.ViewHolder(binding.root) {
    val titleView: TextView = binding.itemTitle
    val ImageView: ImageView = binding.itemImage
    val pubdateView: TextView = binding.itemPubdate
}