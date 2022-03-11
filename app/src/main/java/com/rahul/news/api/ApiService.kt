package com.rahul.news.api

import com.rahul.news.model.local.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?country=in&apiKey=e993cfdeff914722b1538254dfb80b33")
        suspend fun getArticleFromAPI(): NewsResponse

}