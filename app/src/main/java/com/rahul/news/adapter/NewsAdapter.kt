package com.rahul.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.news.R
import com.rahul.news.databinding.NewsItemLayoutBinding
import com.rahul.news.model.local.Article

class NewsAdapter(private val context:Context, private val newsList:List<Article>)
    :RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemLayoutBinding = NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.newsItemLayoutBinding.apply {
            tvDate.text =news.publishedAt
            tvDescription.text = news.description
            tvHeading.text = news.title
            tvSource.text = news.source.name
            Glide.with(context).load(news.urlToImage)
                .placeholder(R.drawable.ic_baseline_image_not_supported_24)
                .into(ivNewsImage)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(val newsItemLayoutBinding: NewsItemLayoutBinding)
        :RecyclerView.ViewHolder(newsItemLayoutBinding.root){}

}