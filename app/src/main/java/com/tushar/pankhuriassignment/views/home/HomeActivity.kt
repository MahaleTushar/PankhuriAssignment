package com.tushar.pankhuriassignment.views.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.tushar.pankhuriassignment.R
import com.tushar.pankhuriassignment.adapters.HomeViewPagerAdapter
import com.tushar.pankhuriassignment.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import android.view.View
import com.bumptech.glide.Glide

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    //Tab layout title texts
    private val tabTexts = arrayOf("Photos", "Videos", "Albums")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        //Initializing views
        initViews()
    }

    private fun initViews() {

        //setting click listener to back arrow
        binding.ivBack.setOnClickListener(this)
        val homeViewPagerAdapter = HomeViewPagerAdapter(this)
        binding.vpHome.adapter = homeViewPagerAdapter
        val tabLayout = binding.tabLayout

        TabLayoutMediator(tabLayout, binding.vpHome) { tab, position ->
            //Displaying tab texts
            tab.text = tabTexts[position]
            binding.vpHome.setCurrentItem(tab.position, true)
        }.attach()

        //Displaying user image
        Glide.with(this).load("https://i.pinimg.com/474x/63/a9/ed/63a9ed675cf2048917818484ab06d03b.jpg")
            .into(binding.ivUser)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.iv_back -> {
                //Handle back button press
                onBackPressed()
            }
        }
    }
}