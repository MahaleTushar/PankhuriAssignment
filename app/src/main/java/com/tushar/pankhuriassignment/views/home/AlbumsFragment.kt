package com.tushar.pankhuriassignment.views.home

import android.os.Bundle
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
import com.tushar.pankhuriassignment.databinding.FragmentAlbumsBinding
import com.tushar.pankhuriassignment.viewmodel.AlbumFragmentViewModel
import com.tushar.pankhuriassignment.viewmodel.VideoFragmentViewModel
import com.tushar.pankhuriassignment.views.home.adapter.AlbumAdapter
import com.tushar.pankhuriassignment.views.home.adapter.VideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class AlbumsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentAlbumsBinding

    private val albumViewModel: AlbumFragmentViewModel by viewModels()

    @Inject
    lateinit var albumAdapter: AlbumAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_albums, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlbumsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initViews() {
        binding.rvAlbums.layoutManager = GridLayoutManager(requireContext(), 3)

        binding.rvAlbums.itemAnimator = DefaultItemAnimator()
        binding.rvAlbums.adapter = albumAdapter

        //fetching Data
        albumViewModel.fetchImageUrls()
        albumViewModel.getPhotosObserver().observe(requireActivity(), Observer {
            albumAdapter.addImageUrls(it)
        })
    }
}