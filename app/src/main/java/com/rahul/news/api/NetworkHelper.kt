package com.rahul.news.api

import com.rahul.news.model.local.Article

sealed class NetworkHelper {

        data class OnSuccess(val responseList: List<Article>) : NetworkHelper()

        data class OnFailure(val error: String) : NetworkHelper()


}