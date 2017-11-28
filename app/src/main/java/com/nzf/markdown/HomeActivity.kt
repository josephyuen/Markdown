package com.nzf.markdown

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.nzf.markdown.adapter.HomeAdapter
import com.nzf.markdown.bean.MDFileBean
import com.nzf.markdown.utils.FilesUtils

/**
 * Created by niezhuofu on 17-11-15.
 */
class HomeActivity: AppCompatActivity() {
    lateinit var homeAdapter : HomeAdapter
    lateinit var recycle : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView(){
        recycle = findViewById(R.id.rv_home_list)
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayout.VERTICAL
        recycle.layoutManager = layoutManager
        initAdapter()
    }

    private fun initAdapter(){
        var fileUtils = FilesUtils.instance
        var path = fileUtils.getFileDirectory(fileUtils.FILEDIR_EXTERNAL,null)
        var datas : List<MDFileBean>? = fileUtils.showAllMDDir(path!!.path)!!
        homeAdapter =  HomeAdapter(this,R.layout.adapter_item_home,datas)
        recycle.adapter = homeAdapter
    }


}