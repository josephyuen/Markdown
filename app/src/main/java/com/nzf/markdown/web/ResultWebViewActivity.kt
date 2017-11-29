package com.nzf.markdown.web

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import com.nzf.markdown.view.WebMarkView

/**
 * Created by joseph on 2017/11/11.
 */

class ResultWebViewActivity : AppCompatActivity(),ViewTreeObserver.OnGlobalLayoutListener{

    private var isFirst : Boolean = true
    private lateinit var path : String

    private lateinit var mWebView : WebMarkView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mWebView = WebMarkView(this)
        setContentView(mWebView)
//        path = intent.getStringExtra(HomeActivity.VIEW_FILE_PATH)

        mWebView.addJavascriptInterface(WebMarkView.AndroidToast(this),"AndroidToast")

        val input : InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        input.showSoftInput(mWebView,0)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mWebView.viewTreeObserver.addOnGlobalLayoutListener(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mWebView.viewTreeObserver.removeOnGlobalLayoutListener(this)
    }


    override fun onGlobalLayout() {
          if(isFirst){
              mWebView.data = WebMarkView.formatFileData(path)//Environment.getExternalStorageDirectory().absolutePath + "/README.md")
              mWebView.loadDefault()
              isFirst = false
          }

    }


}
