package com.nzf.markdown.api

import com.nzf.markdown.video.entity.Item
import com.nzf.markdown.video.entity.Result
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by joseph on 2017/11/30.
 */
interface ApiService {

    /**
     *
     * 分类列表
     *
     * http://static.owspace.com/?c=api&a=getList&p=1&model=1&page_id=0&create_time=0&client=android&version=1.3.0&time=1467867330&device_id=866963027059338&show_sdv=1
     *
     * @param c
     * @param a
     * @param page
     * @param model(0:首页，1：文字，2：声音，3：影像，4：单向历)
     * @param pageId
     * @param time
     * @param deviceId
     * @param show_sdv
     * @return
     */
    @GET("/")
     fun getList(@Query("c") c: String, @Query("a") a: String, @Query("p") page: Int, @Query("model") model: Int, @Query("page_id") pageId: String, @Query("create_time") createTime: String, @Query("client") client: String, @Query("version") version: String, @Query("time") time: Long, @Query("device_id") deviceId: String, @Query("show_sdv") show_sdv: Int): Observable<Result.Companion.Data<List<Item>>>


}