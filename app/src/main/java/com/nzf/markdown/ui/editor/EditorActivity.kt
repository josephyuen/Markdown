package com.nzf.markdown.ui.editor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.view.View
import android.view.Window
import com.nzf.markdown.R
import com.nzf.markdown.ui.fragment.EditorFragment

/**
 * Created by joseph on 2017/11/13.
 */
class EditorActivity : AppCompatActivity() {
    private var container : View? = null
    var editorFragment : EditorFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val slide = Slide()
        window.enterTransition = slide

        setContentView(R.layout.activity_home_editor)
        container = findViewById(R.id.ll_container)
        initStack()
    }

    private fun initStack() {
        val transaction  = supportFragmentManager.beginTransaction()
        editorFragment = EditorFragment()
        transaction.replace(R.id.ll_container,editorFragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(0,R.anim.translate_right_bottom)
    }

}