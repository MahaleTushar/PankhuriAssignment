package com.tushar.pankhuriassignment.di

import android.content.Context
import com.tushar.pankhuriassignment.repository.Repository
import com.tushar.pankhuriassignment.views.home.adapter.AlbumAdapter
import com.tushar.pankhuriassignment.views.home.adapter.PhotosAdapter
import com.tushar.pankhuriassignment.views.home.adapter.StoryAdapter
import com.tushar.pankhuriassignment.views.home.adapter.VideoAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(
    SingletonComponent::class
)
class AppModule {
    @Provides
    fun provideRepository(@ApplicationContext context: Context) = Repository(context)

    @Provides
    fun providePhotoAdapter(): PhotosAdapter = PhotosAdapter()

    @Provides
    fun provideVideoAdapter(): VideoAdapter = VideoAdapter()

    @Provides
    fun provideAlbumAdapter(): AlbumAdapter = AlbumAdapter()

    @Provides
    fun provideStoryAdapter(): StoryAdapter = StoryAdapter()

}