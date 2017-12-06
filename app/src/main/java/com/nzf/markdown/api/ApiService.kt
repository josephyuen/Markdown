package com.nzf.markdown.api

import com.nzf.markdown.video.entity.Bean
import com.nzf.markdown.video.entity.NotesBean
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by joseph on 2017/11/30.
 */
interface ApiService {

    /**
     *
     *http://mobile.yishihui.com/zone/notepub/getNewNoteList.htmls?
     * pageNo=0&pageSize=20&theLastDateTime=1512030650274&device=2&appKey=1001&machineCode=86456503064262&versionCode=26
     */

    @GET("getNewNoteList.htmls")
       fun getHomeList(@Query("pageNo")pageNo: Int,@Query("pageSize")pageSize: Int,
                       @Query("theLastDataTime")theLastDateTime : Long,@Query("device")device: Int,
                       @Query("appKey")appKey: Int,@Query("machineCode")machineCode: String,
                       @Query("versionCode")versionCode: Int): Observable<Bean.DataBean<List<NotesBean>>>
//    http://mobile.yishihui.com/zone/notepub/getNewNoteList.htmls?pageNo=0&pageSize=20&theLastDateTime=1512030650274&device=2&appKey=1001&machineCode=86456503064262&versionCode=26

}