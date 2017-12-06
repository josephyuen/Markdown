package com.nzf.markdown.video

import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException

/**
 * Created by joseph on 2017/11/30.
 */
class StringConverter : Converter<ResponseBody, String> {

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): String {

        return value.string()
    }
}