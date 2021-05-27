package com.tushar.pankhuriassignment.views.home.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tushar.pankhuriassignment.data.Story
import kotlinx.android.synthetic.main.photo_card.view.*
import kotlinx.android.synthetic.main.photo_card.view.iv_card
import kotlinx.android.synthetic.main.story_card.view.*


class StoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(story: Story) {
        Glide.with(view).load(story.url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(view.iv_card)
        view.tv_story.text = story.story

    }
}