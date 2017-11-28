package com.nzf.markdown.adapter

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nzf.markdown.R
import com.nzf.markdown.bean.MDFileBean
import com.nzf.markdown.utils.ConvertUtils
import com.nzf.markdown.utils.FilesUtils

/**
 * Created by joseph on 2017/11/24.
 */
class HomeAdapter(mContext: Context?, mLayoutRes: Int?, mList: List<MDFileBean>?) :
        BaseSingleAdapter<MDFileBean, HomeAdapter.Companion.HomeFileHolder>(mContext, mLayoutRes, mList) {

    override fun convert(holder: HomeFileHolder, data: MDFileBean) {
        holder.setFileName(R.id.tv_title,data.fileName!!).setModifyTime(R.id.tv_modify,data.fileLastTime!!).
                setFileSize(R.id.tv_size,data.fileSize!!).setLeftPic(R.id.aiv,data.fileType!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeFileHolder =
            HomeFileHolder.get(mContext,mLayoutRes, parent)


    companion object {

        class HomeFileHolder(itemView: View) : BaseSingleViewHolder(itemView) {
            lateinit var tv_modify : AppCompatTextView
            lateinit var tv_title : AppCompatTextView
            lateinit var tv_size : AppCompatTextView
            lateinit var aiv : AppCompatImageView

            fun setLeftPic(@IdRes resId: Int,fileType : Int): HomeFileHolder{
                aiv = getView(resId) as AppCompatImageView
                if(fileType == FilesUtils.FILETYPE_DIR){
                      aiv.setImageResource(R.drawable.ic_folder)
                }else{
                    aiv.setImageResource(R.drawable.ic_file)
                }

                return this
            }

            fun setModifyTime(@IdRes resId : Int,time : Long?): HomeFileHolder {
               tv_modify = getView(resId) as AppCompatTextView
               tv_modify.text = ConvertUtils.convertTime(time!!)
               return this
           }

           fun setFileName(@IdRes resId: Int,name : String): HomeFileHolder {
               tv_title = getView(resId) as AppCompatTextView
               tv_title.text = name
               return this
           }

           fun setFileSize(@IdRes resId: Int,size : Long) : HomeFileHolder{
               tv_size = getView(resId) as AppCompatTextView
               tv_size.text = ConvertUtils.convertSize(size)
               return this
           }

           companion object {
              fun get(mContext: Context?, @LayoutRes layoutRes: Int?, parent: ViewGroup?): HomeFileHolder {
                  val view = LayoutInflater.from(mContext).inflate(layoutRes!!,parent,false)
                  return HomeFileHolder(view)
              }
           }

        }

    }





}