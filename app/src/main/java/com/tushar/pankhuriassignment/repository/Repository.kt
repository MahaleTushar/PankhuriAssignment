package com.tushar.pankhuriassignment.repository

import android.content.Context
import com.tushar.pankhuriassignment.R
import com.tushar.pankhuriassignment.data.Story
import javax.inject.Inject

class Repository @Inject constructor(val context: Context) {

    // this function will provide image urls for Photos
    fun fetchImageUrls(): Array<String> {
        val resource = context.resources
        return (resource.getStringArray(R.array.photos))
    }

    // this function will provide image urls for Video
    fun fetchVideoImageUrl(): Array<String> {
        val resource = context.resources
        return (resource.getStringArray(R.array.video_images))
    }

    // this function will provide image urls for Album

    fun fetchAlbumUrl(): Array<String> {
        val resource = context.resources
        return (resource.getStringArray(R.array.album_images))
    }

    // this function will provide Stories data
    fun fetchStoryData(): ArrayList<Story> {
        var storyData = ArrayList<Story>()
        val resource = context.resources
        val storyTitles = resource.getStringArray(R.array.story_title)
        val storyImages = resource.getStringArray(R.array.story_images)
        for (i in storyImages.indices) {
            storyData.add(Story(storyTitles[i], storyImages[i]))
        }

        return storyData
    }
}