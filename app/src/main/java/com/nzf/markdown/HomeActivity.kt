package com.nzf.markdown

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.nzf.markdown.adapter.HomeAdapter
import com.nzf.markdown.adapter.SimpleClickListener
import com.nzf.markdown.bean.MDFileBean
import com.nzf.markdown.ui.editor.EditorActivity
import com.nzf.markdown.utils.FilesUtils
import com.nzf.markdown.web.ResultWebViewActivity
import java.util.*



/**
 * Created by niezhuofu on 17-11-15.
 */
class HomeActivity: AppCompatActivity(),View.OnClickListener,SimpleClickListener<MDFileBean>{

    private lateinit var floatButton : FloatingActionButton
    private lateinit var homeAdapter : HomeAdapter
    private lateinit var recycle : RecyclerView
    private lateinit var stack : Stack<String>
    private lateinit var curPath : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView(){
        stack = Stack()
        recycle = findViewById(R.id.rv_home_list)
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayout.VERTICAL
        recycle.layoutManager = layoutManager
        initAdapter()
        floatButton = findViewById(R.id.create_file)
        floatButton.setOnClickListener(this@HomeActivity)
    }

    private fun initAdapter(){
        var fileUtils = FilesUtils.instance
        var path = fileUtils.getFileDirectory(fileUtils.FILEDIR_EXTERNAL,null)
        stack.clear()
        stack.add(path!!.path)
        var datas : List<MDFileBean>? = fileUtils.showAllMDDir(path.path)!!
        homeAdapter =  HomeAdapter(this,R.layout.adapter_item_home,datas)
        homeAdapter.setPerformClick(this)
        recycle.addItemDecoration(SpaceItemDecoration(8))
        recycle.adapter = homeAdapter
    }


    override fun onClick(v: View?) {
        if(R.id.create_file == v!!.id){
            val fade = Fade()
            window.exitTransition = fade
            val activityOptionsCompat = ActivityOptionsCompat.makeClipRevealAnimation(v, v.width / 2, v.height / 2, 20, 20)
            val intent = Intent(this@HomeActivity,EditorActivity::class.java)
            startActivity(intent, activityOptionsCompat.toBundle())
        }
    }

    companion object {
       private val TAG = "HomeActivity"

        val VIEW_FILE_PATH = "file_path_to_view"

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


    override fun performClick(v: View, data : MDFileBean) {
        Log.i(TAG,data.filePath)

        if(data.fileType != FilesUtils.FILETYPE_DIR){
            val fade = Fade()
            window.exitTransition = fade
            val options = ActivityOptionsCompat.makeClipRevealAnimation(v, v.width / 2, v.height / 2, 20, 20)
            val intent = Intent(this@HomeActivity,ResultWebViewActivity :: class.java)
            intent.putExtra(VIEW_FILE_PATH,data.filePath)
            startActivity(intent,options.toBundle())
            return
        }

        //list files from the clicked folder AND refresh view
        stack.add(data.filePath)
        homeAdapter.notifyDataListChange(FilesUtils.instance.showAllMDDir(data.filePath))
    }

    override fun onBackPressed() {
        if(stack.size > 1){
            stack.pop()
            homeAdapter.notifyDataListChange(FilesUtils.instance.showAllMDDir(stack.peek()))
        }else{
//            finish()
        }

    }

}