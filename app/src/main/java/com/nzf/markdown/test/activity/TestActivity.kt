package com.nzf.markdown.test.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.nzf.markdown.R

/**
 * Created by niezhuofu on 17-11-25.
 */
class TestActivity : AppCompatActivity() {
     private val TAG = "AppCompatActivity"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_home)
    }
}