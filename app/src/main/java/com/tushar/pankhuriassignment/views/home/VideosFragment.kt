package com.tushar.pankhuriassignment.views.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.tushar.pankhuriassignment.R
import com.tushar.pankhuriassignment.databinding.FragmentVideosBinding
import com.tushar.pankhuriassignment.viewmodel.PhotosFragmentViewModel
import com.tushar.pankhuriassignment.viewmodel.VideoFragmentViewModel
import com.tushar.pankhuriassignment.views.home.adapter.PhotosAdapter
import com.tushar.pankhuriassignment.views.home.adapter.VideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VideosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class VideosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentVideosBinding
    private val videoViewModel: VideoFragmentViewModel by viewModels()

    @Inject
    lateinit var videoAdapter: VideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_videos, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VideosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initViews() {
        binding.rvVideos.layoutManager = GridLayoutManager(requireContext(), 3)

        binding.rvVideos.itemAnimator = DefaultItemAnimator()
        binding.rvVideos.adapter = videoAdapter

        //fetching Data
        videoViewModel.fetchImageUrls()
        videoViewModel.getPhotosObserver().observe(requireActivity(), Observer {
            videoAdapter.addImageUrls(it)
        })
    }
}
