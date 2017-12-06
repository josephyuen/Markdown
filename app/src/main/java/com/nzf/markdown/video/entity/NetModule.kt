package com.nzf.markdown.video.entity

import com.nzf.markdown.BuildConfig
import com.nzf.markdown.api.ApiService
import com.nzf.markdown.video.EntityUtils
import com.nzf.markdown.video.StringConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by joseph on 2017/11/30.
 */
class NetModule {
    companion object {
        private var apiService : ApiService? = null

        fun getNetInstance() : ApiService{
            if(apiService == null){
                synchronized(NetModule::class.java.simpleName) {
                    if(apiService == null) {
                        val loggingInterceptor = HttpLoggingInterceptor()
                        loggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                        val okhttpClient = OkHttpClient.Builder()
                                .connectTimeout(6, TimeUnit.SECONDS)
                                .writeTimeout(8, TimeUnit.SECONDS)
                                .readTimeout(10, TimeUnit.SECONDS)
                                .addInterceptor(loggingInterceptor)
                                .build()

                        val retrofit = Retrofit.Builder()
                                .client(okhttpClient)
                                .baseUrl("http://mobile.yishihui.com/zone/notepub/")
//                                .baseUrl("http://static.owspace.com/")
                                .addConverterFactory(StringConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create(EntityUtils.gson))
                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                .build()

                        apiService = retrofit.create(ApiService::class.java)
                    }
                }
            }
            return apiService!!
        }
    }

}