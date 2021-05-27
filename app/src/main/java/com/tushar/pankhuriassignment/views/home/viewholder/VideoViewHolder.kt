package com.tushar.pankhuriassignment.views.home.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.photo_card.view.*

class VideoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(imageUrl: String) {
        Glide.with(view).load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(view.iv_card)

    }
}