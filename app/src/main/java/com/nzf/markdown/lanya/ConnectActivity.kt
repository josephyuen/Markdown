package com.nzf.markdown.lanya

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.nzf.markdown.R



/**
 * Created by joseph on 2017/11/17.
 */
class ConnectActivity : AppCompatActivity() {

    //定义
    private var mBluetoothAdapter: BluetoothAdapter? = null
    private var text: TextView? = null
    private var text2: TextView? = null
    private var text3: TextView? = null
    private var botton: Button? = null


    //定义广播接收
    private val mReceiver = object : BroadcastReceiver() {


        override fun onReceive(context: Context, intent: Intent) {

            val action = intent.action

            Log.e("ywq", action)
            if (action == BluetoothDevice.ACTION_FOUND) {
                val device = intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)

                if (device.bondState == BluetoothDevice.BOND_BONDED) {    //显示已配对设备
                    text!!.append("\n" + device.name + "==>" + device.address + "\n")
                } else if (device.bondState != BluetoothDevice.BOND_BONDED) {
                    text3!!.append("\n" + device.name + "==>" + device.address + "\n")
                }

            } else if (action == BluetoothAdapter.ACTION_DISCOVERY_FINISHED) {
                text2!!.text = "搜索完成..."
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)

        text = findViewById(R.id.textView)   //已配对
        text2 = findViewById(R.id.textView2)//状态信息
        text3 = findViewById(R.id.textView3) //未配对
        botton = findViewById(R.id.button)

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        registerReceiver(mReceiver, filter)
        val filter2 = IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        registerReceiver(mReceiver, filter2)

        botton!!.setOnClickListener {
            if (!mBluetoothAdapter!!.isEnabled) {
                mBluetoothAdapter!!.enable()

            }

            mBluetoothAdapter!!.startDiscovery()
            text2!!.text = "正在搜索..."
        }
    }

    public override fun onDestroy() {
        super.onDestroy()
        //解除注册
        unregisterReceiver(mReceiver)
        Log.e("destory", "解除注册")
    }

}