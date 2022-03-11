package com.rahul.news.api

import com.rahul.news.model.local.Article

sealed class NetworkHelper {
    sealed class NetworkHelperClass{
        data class OnSuccess_1(val responseList: List<Article>) : NetworkHelperClass()
        //    data class OnSuccess_2(val responseList: ResponseModel) : NetworkHelperClass()
        data class OnFailure(val error: String) : NetworkHelperClass()

    }

}