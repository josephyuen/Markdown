package com.nzf.markdown.adapter

import android.view.View

/**
 * Created by joseph on 2017/11/28.
 */
interface SimpleClickListener<in T>{

    fun performClick(v : View,data : T)
}