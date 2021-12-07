package com.example.footballnews.bottomfragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.footballnews.R
import com.example.footballnews.adapters.rvadapters.HomeAdapter
import com.example.footballnews.databinding.FragmentNewsAllBinding
import com.example.footballnews.network.NetworkHelper
import com.example.footballnews.viewmodel.NewsResource
import com.example.footballnews.viewmodel.NewsViewModel
import com.example.footballnews.viewmodel.NewsViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NewsAll : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var fragment: FragmentNewsAllBinding
    private lateinit var networkHelper: NetworkHelper
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragment = FragmentNewsAllBinding.inflate(inflater, container, false)

        homeAdapter = HomeAdapter(requireContext())
        fragment.rvc.adapter = homeAdapter

        networkHelper = NetworkHelper(requireContext())
        newsViewModel = ViewModelProvider(
            requireActivity(),
            NewsViewModelFactory(networkHelper)
        )[NewsViewModel::class.java]

        newsViewModel.getAllNews().observe(requireActivity(), {
            when (it) {
                is NewsResource.LOADING -> {
                    Log.d(TAG, "onCreateView: Loading")
                }
                is NewsResource.ERROR -> {
                    Log.d(TAG, "onCreateView: ${it.message}")
                }
                is NewsResource.SUCCESS -> {
                    fragment.spinKit.visibility = View.GONE
                    Log.d(TAG, "onCreateView: ${it.allNews}")
                    homeAdapter.submitList(it.allNews)
                }
            }
        })

        return fragment.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsAll().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}