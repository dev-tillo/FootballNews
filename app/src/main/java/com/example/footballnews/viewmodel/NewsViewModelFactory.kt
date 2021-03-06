package com.example.footballnews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.footballnews.network.NetworkHelper

class NewsViewModelFactory(private val networkHelper: NetworkHelper):
    ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(NewsViewModel::class.java)->{
                NewsViewModel(networkHelper) as T
            }
            else ->throw Exception("Error")
        }
    }
}