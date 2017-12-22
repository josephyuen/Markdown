package com.nzf.markdown.adapter.multitype

import android.support.v7.widget.RecyclerView

/**
 * Created by joseph on 2017/12/11.
 */
interface ICustomAdapter {
   fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder,position: Int)
}