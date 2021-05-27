package com.tushar.pankhuriassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tushar.pankhuriassignment.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumFragmentViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    var imageUrl: MutableLiveData<ArrayList<String>>


    init {

        imageUrl = MutableLiveData()
    }

    fun getPhotosObserver(): MutableLiveData<ArrayList<String>> {
        return imageUrl
    }

    fun fetchImageUrls() {
        val imageUrls = repository.fetchAlbumUrl()

        imageUrl.postValue(imageUrls.toCollection(ArrayList()))

    }
}