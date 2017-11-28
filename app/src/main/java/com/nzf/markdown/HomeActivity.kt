package com.nzf.markdown

import android.graphics.Rect
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.nzf.markdown.adapter.HomeAdapter
import com.nzf.markdown.bean.MDFileBean
import com.nzf.markdown.ui.editor.EditorActivity
import com.nzf.markdown.utils.FilesUtils

/**
 * Created by niezhuofu on 17-11-15.
 */
class HomeActivity: AppCompatActivity(),View.OnClickListener{
    private lateinit var homeAdapter : HomeAdapter
    private lateinit var recycle : RecyclerView

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
        findViewById<FloatingActionButton>(R.id.create_file).setOnClickListener(this@HomeActivity)
    }

    private fun initAdapter(){
        var fileUtils = FilesUtils.instance
        var path = fileUtils.getFileDirectory(fileUtils.FILEDIR_EXTERNAL,null)
        var datas : List<MDFileBean>? = fileUtils.showAllMDDir(path!!.path)!!
        homeAdapter =  HomeAdapter(this,R.layout.adapter_item_home,datas)
        recycle.addItemDecoration(SpaceItemDecoration(8))
        recycle.adapter = homeAdapter
    }


    override fun onClick(v: View?) {
        if(R.id.create_file == v!!.id){
              EditorActivity.startCreateFile("",this)
        }
    }


    companion object {
       class SpaceItemDecoration(private var space: Int) : RecyclerView.ItemDecoration() {

           override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
               outRect!!.left = space
               outRect.right = space
               outRect.bottom = space

               if (parent!!.getChildLayoutPosition(view) == 0)
                   outRect.top = space
           }
       }

    }

}