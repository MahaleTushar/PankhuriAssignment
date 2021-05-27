package com.tushar.pankhuriassignment.views.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tushar.pankhuriassignment.R
import com.tushar.pankhuriassignment.data.Story
import com.tushar.pankhuriassignment.views.home.viewholder.PhotoViewHolder
import com.tushar.pankhuriassignment.views.home.viewholder.StoryViewHolder

class StoryAdapter : RecyclerView.Adapter<StoryViewHolder>() {
    val stories = ArrayList<Story>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_card, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.onBind(stories[position])
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    fun addStories(data: ArrayList<Story>) {
        stories.addAll(data)
        notifyDataSetChanged()
    }
}