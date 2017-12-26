package app.com.thetechnocafe.kotlinweather.Networking

import android.util.Log
import app.com.thetechnocafe.kotlinweather.Consts.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit




/**
 * Created by gurleensethi on 16/06/17.
 */
object NetworkService {
    val retrofit: Retrofit

    val client : OkHttpClient

    init {

        val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            //打印retrofit日志
            Log.i("RetrofitLog", "retrofitBack = " + message)
        })
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(3000,TimeUnit.SECONDS)
                .readTimeout(3000,TimeUnit.SECONDS)
                .writeTimeout(3000,TimeUnit.SECONDS)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
//                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getMetaWeatherApi() = retrofit.create(MetaWeatherApi::class.java)
}