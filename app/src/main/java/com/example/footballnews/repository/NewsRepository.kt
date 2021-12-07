package com.example.footballnews.repository

import com.example.footballnews.retrofit.ApiService
import kotlinx.coroutines.flow.flow

class NewsRepository(private val apiService: ApiService) {

    fun getResultNews() = flow { emit(apiService.getNews()) }

}