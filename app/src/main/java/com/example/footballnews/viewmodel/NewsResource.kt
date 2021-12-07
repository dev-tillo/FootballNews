package com.example.footballnews.viewmodel

import com.example.footballnews.models.Futboluz


sealed class NewsResource {

    object LOADING : NewsResource()

    class SUCCESS(val allNews: Futboluz) : NewsResource()

    class ERROR(val message: String) : NewsResource()
}