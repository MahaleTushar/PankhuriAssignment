package com.tushar.pankhuriassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tushar.pankhuriassignment.data.Story
import com.tushar.pankhuriassignment.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    var storyData: MutableLiveData<ArrayList<Story>>


    init {

        storyData = MutableLiveData()
    }

    fun getStoryObserver(): MutableLiveData<ArrayList<Story>> {
        return storyData
    }

    fun fetchStories() {
        val stories = repository.fetchStoryData()
        storyData.postValue(stories)

    }
}