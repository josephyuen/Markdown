package com.nzf.markdown.lanya

import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


/**
 * Created by joseph on 2017/11/17.
 */
class BluetoothReceiver : BroadcastReceiver() {

    private var pin = "1234"  //此处为你要连接的蓝牙设备的初始密钥，一般为1234或0000

    //广播接收器，当远程蓝牙设备被发现时，回调函数onReceiver()会被执行
    override fun onReceive(context: Context, intent: Intent) {

        val action = intent.action //得到action
        Log.e("action1=", action)
        var btDevice: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)  //创建一个蓝牙device对象,从Intent中获取设备对象

        if (BluetoothDevice.ACTION_FOUND == action) {  //发现设备
            Log.e("发现设备:", "[" + btDevice!!.name + "]" + ":" + btDevice.address)

            if (btDevice.name.contains("HC-05"))
            //HC-05设备如果有多个，第一个搜到的那个会被尝试。
            {
                if (btDevice.bondState == BluetoothDevice.BOND_NONE) {

                    Log.e("ywq", "attemp to bond:" + "[" + btDevice.name + "]")
                    try {
                        //通过工具类ClsUtils,调用createBond方法
                        ClsUtils.createBond(btDevice.javaClass, btDevice)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
            } else
                Log.e("error", "Is faild")
        } else if (action == "android.bluetooth.device.action.PAIRING_REQUEST")
        //再次得到的action，会等于PAIRING_REQUEST
        {
            Log.e("action2=", action)
            if (btDevice!!.name.contains("HC-05")) {
                Log.e("here", "OKOKOK")

                try {

                    //1.确认配对
                    ClsUtils.setPairingConfirmation(btDevice.javaClass, btDevice, true)
                    //2.终止有序广播
                    Log.i("order...", "isOrderedBroadcast:$isOrderedBroadcast,isInitialStickyBroadcast:$isInitialStickyBroadcast")
                    abortBroadcast()//如果没有将广播终止，则会出现一个一闪而过的配对框。
                    //3.调用setPin方法进行配对...
                    val ret = ClsUtils.setPin(btDevice.javaClass, btDevice, pin)

                } catch (e: Exception) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                }

            } else
                Log.e("提示信息", "这个设备不是目标蓝牙设备")

        }
    }
}