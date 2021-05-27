package com.tushar.pankhuriassignment.views.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tushar.pankhuriassignment.R
import com.tushar.pankhuriassignment.views.home.viewholder.PhotoViewHolder

class PhotosAdapter : RecyclerView.Adapter<PhotoViewHolder>() {
    val imageUrl = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_card, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
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