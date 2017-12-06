package com.nzf.markdown.video

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * Created by joseph on 2017/11/30.
 */
class StringConverterFactory : Converter.Factory() {
    companion object {
        fun create(): StringConverterFactory {
            return StringConverterFactory()
        }
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return if (type === String::class.java) {
            StringConverter()
        } else null
    }

}