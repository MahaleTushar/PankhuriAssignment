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
import androidx.recyclerview.widget.LinearLayoutManager
import com.tushar.pankhuriassignment.R
import com.tushar.pankhuriassignment.databinding.FragmentPhotosBinding
import com.tushar.pankhuriassignment.viewmodel.PhotosFragmentViewModel
import com.tushar.pankhuriassignment.views.home.adapter.PhotosAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class PhotosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val TAG = "PhotosFragment"
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentPhotosBinding
    private val photosViewsModel: PhotosFragmentViewModel by viewModels()

    @Inject
    lateinit var photosAdapter: PhotosAdapter
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PhotosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initViews() {
        binding.rvPhotos.layoutManager = GridLayoutManager(requireContext(), 3)

        binding.rvPhotos.itemAnimator = DefaultItemAnimator()
        binding.rvPhotos.adapter = photosAdapter

        //fetching Data
        photosViewsModel.fetchImageUrls()
        photosViewsModel.getPhotosObserver().observe(requireActivity(), Observer {
            Log.d(TAG, "initViews: ${it.size}")
            photosAdapter.addImageUrls(it)
        })
    }


}