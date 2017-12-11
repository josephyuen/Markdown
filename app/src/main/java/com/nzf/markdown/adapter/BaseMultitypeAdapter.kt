package com.nzf.markdown.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by joseph on 2017/12/7.
 */
abstract class BaseMultitypeAdapter<VH : RecyclerView.ViewHolder>(context: Context, viewRes:
SparseArray<Int>, datas: SparseArray<Any>,holders : SparseArray<Any> ) : RecyclerView.Adapter<VH>() {

    private lateinit var viewTypeRes: SparseArray<Int>
    private lateinit var mContext: Context
    private lateinit var typeDatas: SparseArray<Any>
    private lateinit var holderClass : SparseArray<Any>

    override fun getItemViewType(position: Int): Int {
        //父类不知道子类具体的布局
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: VH?, position: Int) {
           val type : Int = getItemViewType(position)


    }

    override fun getItemCount(): Int = typeDatas.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH{
        val view = LayoutInflater.from(mContext).inflate(viewTypeRes.get(viewType),parent,false)
        return createHolder(view)
    }

    abstract fun createHolder(view : View) : VH

//    abstract fun convert(holder : )


}