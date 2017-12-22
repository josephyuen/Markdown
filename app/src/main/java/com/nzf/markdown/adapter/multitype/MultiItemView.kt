package com.nzf.markdown.adapter.multitype

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import java.util.*

/**
 * Created by joseph on 2017/12/11.
 */
abstract class MultiItemView<T> {
    private val list: MutableList<MultiItemView<T>>

    @get:LayoutRes
    abstract val layoutId: Int

    val childList: List<MultiItemView<T>>
        get() = list

    val maxRecycleCount: Int
        get() = 5

    init {
        list = ArrayList()
    }

    abstract fun onBindViewHolder(holder: BaseViewHolder, item: T, position: Int)

    fun isForViewType(item: T, postion: Int): Boolean {
        return true
    }

    fun addChildeItemView(multiItemView: MultiItemView<T>): MultiItemView<T> {
        list.add(multiItemView)
        return this
    }

    fun haveChild(): Boolean {
        return !list.isEmpty()
    }

    fun onViewAttachedToWindow(viewHolder: RecyclerView.ViewHolder) {}
}
