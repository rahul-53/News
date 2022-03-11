package com.rahul.news.model.local

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)