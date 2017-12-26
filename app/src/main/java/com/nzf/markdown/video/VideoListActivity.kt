package com.nzf.markdown.video

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import app.com.thetechnocafe.kotlinweather.Home.HomeActivity
import com.alibaba.fastjson.JSON
import com.nzf.markdown.R
import com.nzf.markdown.video.entity.Bean
import com.nzf.markdown.video.entity.NetModule
import com.nzf.markdown.video.entity.NotesBean
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*


/**
 * Created by joseph on 2017/11/30.
 */
class VideoListActivity : AppCompatActivity() {
    private lateinit var recycler : RecyclerView
    private lateinit var deviceId : String
    private var pageId : String = "0"
    private var page : Int = 1

    private var snowFlake : SnowFlake = SnowFlake(0,1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_app)
        recycler = findViewById(R.id.rv_home_list)

        Thread(Runnable {
            val r = Random()
            while (true){
//                bindData()
                Thread.sleep((r.nextInt(3000).toLong())+ 532L)
//                bindData()
            }
        }).start()
    }

    private var isFirst : Boolean = true

    override fun onResume() {
        super.onResume()
        if(isFirst){
            val handler = Handler()
            handler.postDelayed({


                val intent = Intent(this@VideoListActivity, HomeActivity:: class.java)
                startActivity(intent)
            },500)

            isFirst = false
        }

    }

    private fun bindData(){
        deviceId = AppUtils.getDeviceId(this)
        getListByPage()
    }

    //machinecode:  86456503064262
    private fun getListByPage(){
        NetModule.getNetInstance().getHomeList((Math.random() * 10).toInt(),50, (System.currentTimeMillis() - (Math.random() * 10020)).toLong()
        ,2,1001,"56456503064254",26)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Bean.DataBean<List<NotesBean>>>(){
                    override fun onError(e: Throwable?) {
                        Log.i("video-jia",JSON.toJSONString(e))
                    }

                    override fun onNext(t: Bean.DataBean<List<NotesBean>>) {
                        Log.i("video-jia",JSON.toJSONString(t))
                    }

                    override fun onCompleted() {

                    }
                })
    }










// 编程大部分的时间都是在调试,调试要点在于快速定位问题,
//定位问题需要将所有与此问题相关联的逻辑提取出来,一一排除,
//不能死扣着一段逻辑不放.

}