package com.tushar.pankhuriassignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tushar.pankhuriassignment.views.home.AlbumsFragment
import com.tushar.pankhuriassignment.views.home.PhotosFragment
import com.tushar.pankhuriassignment.views.home.VideosFragment

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return PhotosFragment()
            1 -> return VideosFragment()
            else -> return AlbumsFragment()
        }
    }
}