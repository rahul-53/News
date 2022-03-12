package com.rahul.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.rahul.news.R
import com.rahul.news.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var detailsBinding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_details)

        val url = intent.getStringExtra("URL")
        if (url!=null){
            detailsBinding.webView.settings.javaScriptEnabled= true
            detailsBinding.webView.settings.userAgentString =
                "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            detailsBinding.webView.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)

                }
            }

            detailsBinding.webView.loadUrl(url)
        }
    }
}