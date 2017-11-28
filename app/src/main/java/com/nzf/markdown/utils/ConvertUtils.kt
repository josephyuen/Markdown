package com.nzf.markdown.utils

/**
 * Created by joseph on 2017/11/28.
 */
object ConvertUtils {
     fun convertTime(time : Long) : String{
        val inteval : Long = (System.currentTimeMillis() - time) / 1000L
        if((inteval / 60) < 1){
            return "${inteval}秒前"
        }

        if((inteval / 60 / 60) < 1){
            return "${(inteval / 60)}分钟前"
        }

        if((inteval / 60 / 60 / 24) < 1){
            return "${(inteval / 60 / 60)}小时前"
        }

        if((inteval / 60 / 60 / 24 / 31) < 1){
            return "${(inteval / 60 / 60 / 24)}天前"
        }

        if((inteval / 60 / 60 / 24 / 365) < 1){
            return "${(inteval / 60 / 60 / 24 / 30)}月前"
        }

        return "${(inteval / 60 / 60 / 24 / 365)}年前"
    }


    fun convertSize(size : Long) : String{
        if((size / 1024) < 1){
            return "${size}Byte."
        }

        return "${(size / 1024)}Kb."
    }


}