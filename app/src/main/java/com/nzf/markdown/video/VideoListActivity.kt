package com.nzf.markdown.video

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Spinner
import com.alibaba.fastjson.JSON
import com.nzf.markdown.R
import com.nzf.markdown.video.entity.Item
import com.nzf.markdown.video.entity.NetModule
import com.nzf.markdown.video.entity.Result
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by joseph on 2017/11/30.
 */
class VideoListActivity : AppCompatActivity() {
    private lateinit var recycler : RecyclerView
    private lateinit var deviceId : String
    private var pageId : String = "0"
    private var page : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recycler = findViewById(R.id.rv_home_list)
        bindData()
    }

    private fun bindData(){
        deviceId = AppUtils.getDeviceId(this)

        val spinner = Spinner(this)


        getListByPage(page,pageId,deviceId)

        val linearManager = LinearLayoutManager(this)
        recycler.layoutManager = linearManager

    }

    private fun getListByPage(page: Int,pageId: String, deviceId: String){
        NetModule.getNetInstance().getList("api","getList",page,3,pageId,"0",
                "android","1.3.0", TimeUtil.currentSeconds, deviceId,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Result.Companion.Data<List<Item>>>(){
                    override fun onError(e: Throwable?) {
                         e!!.printStackTrace()
                    }

                    override fun onNext(t: Result.Companion.Data<List<Item>>?) {
                         Log.i("video", JSON.toJSONString(t!!.datas))

                        for (data in t!!.datas!!){
                            Log.i("video",data.getVideo())

                        }

                    }

                    override fun onCompleted() {

                    }
                })

    }

}