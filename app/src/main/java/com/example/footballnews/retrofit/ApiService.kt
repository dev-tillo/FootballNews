package com.example.footballnews.retrofit

import com.example.footballnews.models.Futboluz
import com.example.footballnews.models.FutboluzItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/user/getLiveMatches")
    suspend fun getNews(): Response<Futboluz>

}