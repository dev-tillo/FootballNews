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
import com.example.footballnews.databinding.FragmentChampionatsBinding
import com.example.footballnews.models.FutboluzItem
import com.example.footballnews.network.NetworkHelper
import com.example.footballnews.viewmodel.NewsResource
import com.example.footballnews.viewmodel.NewsViewModel
import com.example.footballnews.viewmodel.NewsViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Championats : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var fragment: FragmentChampionatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragment = FragmentChampionatsBinding.inflate(inflater, container, false)
        fragment.apply {
            imageElasticView.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
            imageElasticView1.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
            imageElasticView2.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
            imageElasticView3.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
            imageElasticView4.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
            imageElasticView5.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
            imageElasticView6.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
            imageElasticView7.setOnClickListener {
                findNavController().navigate(R.id.tabAndViewpager)
            }
        }
        return fragment.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Championats().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}