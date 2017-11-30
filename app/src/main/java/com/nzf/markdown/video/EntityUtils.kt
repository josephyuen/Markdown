package com.nzf.markdown.video

import com.google.gson.GsonBuilder
import org.joda.time.DateTime

/**
 * Created by joseph on 2017/11/30.
 */
object EntityUtils {

    val gson = GsonBuilder()
            .registerTypeAdapter(DateTime::class.java, DateTimeTypeAdapter())
            .create()

}
