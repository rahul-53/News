package com.rahul.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.rahul.news.adapter.NewsAdapter
import com.rahul.news.databinding.ActivityMainBinding
import com.rahul.news.model.local.Article
import com.rahul.news.repository.NewsRepository
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rahul.news.R
import com.rahul.news.api.NetworkHelper
import com.rahul.news.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    var articleList = emptyList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        newsViewModel =ViewModelProvider(this)[NewsViewModel::class.java]
        getArticle()
    }

    private fun setAdapter(){
        newsAdapter = NewsAdapter(this, articleList)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.newsRecyclerview.apply {
            adapter = newsAdapter
            layoutManager = linearLayoutManager
        }
    }
   private fun getArticle(){
        newsViewModel.callNewsApi()
       newsViewModel.liveData.observe(this){
            it.let {
                when(it){
                    is NetworkHelper.OnSuccess ->{
                        articleList =it.responseList as ArrayList<Article>
                        setAdapter()
                    }
                    else ->{
                        Toast.makeText(this@MainActivity, "Error occured", Toast.LENGTH_SHORT).show()
                    }
                }
            }
       }
   }

}