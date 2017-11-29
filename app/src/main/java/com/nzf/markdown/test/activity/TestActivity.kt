package com.nzf.markdown.test.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.nzf.markdown.R

/**
 * Created by niezhuofu on 17-11-25.
 */
class TestActivity : AppCompatActivity() {
     private val TAG = "AppCompatActivity"
     lateinit var webview : WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webview = findViewById(R.id.webview)
        webview.webViewClient = object : WebViewClient(){}

        webview.webChromeClient = object : WebChromeClient(){}

        webview.settings.javaScriptEnabled = true
        webview.settings.allowContentAccess = true
        webview.settings.databaseEnabled = true
        webview.settings.domStorageEnabled = true
        webview.settings.setAppCacheEnabled(true)
        webview.settings.savePassword = false
        webview.settings.saveFormData = false
        webview.settings.useWideViewPort = true
        webview.settings.loadWithOverviewMode = true

//        webview.loadUrl("http://www.baidu.com")
        webview.loadUrl("file:///android_asset/gif/index.html")

    }
}