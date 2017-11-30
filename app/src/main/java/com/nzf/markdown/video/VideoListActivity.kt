package com.nzf.markdown.video

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.nzf.markdown.R

/**
 * Created by joseph on 2017/11/30.
 */
class VideoListActivity : AppCompatActivity() {
    private lateinit var recycler : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recycler = findViewById(R.id.rv_home_list)
        bindData()
    }

    private fun bindData() {


    }

}