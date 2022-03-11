package com.rahul.news.repository

import com.rahul.news.api.ApiService
import com.rahul.news.api.Network
import com.rahul.news.model.local.Article

class NewsRepository {
    private fun getService(): ApiService = Network.getRetrofit().create(ApiService::class.java)
    suspend fun getNews(): List<Article> {
        return getService().getArticleFromAPI().articles
    }
}