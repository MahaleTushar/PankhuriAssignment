package com.tushar.pankhuriassignment.views.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tushar.pankhuriassignment.R
import com.tushar.pankhuriassignment.views.home.ImageViewHolder

class PhotosAdapter : RecyclerView.Adapter<ImageViewHolder>() {
    val imageUrl = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_card, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(imageUrl[position])
    }

    override fun getItemCount(): Int {
        return imageUrl.size
    }

    fun addImageUrls(url: ArrayList<String>) {
        imageUrl.addAll(url)
        notifyDataSetChanged()
    }
}