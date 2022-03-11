package com.rahul.news.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahul.news.api.NetworkHelper
import com.rahul.news.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    private val newsRepository = NewsRepository()
    private val mutableLiveData = MutableLiveData<NetworkHelper>()
    val liveData: LiveData<NetworkHelper> = mutableLiveData

    fun callNewsApi(){
        CoroutineScope(Dispatchers.IO).launch {
            val news = newsRepository.getNews()
            mutableLiveData.postValue(NetworkHelper.OnSuccess(news))
        }
    }
}