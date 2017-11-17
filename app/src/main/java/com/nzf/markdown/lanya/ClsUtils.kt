package com.nzf.markdown.lanya

import android.bluetooth.BluetoothDevice
import android.util.Log


/**
 * Created by joseph on 2017/11/17.
 */
object ClsUtils {
    //配对
    @Throws(Exception::class)
    fun createBond(btClass: Class<*>, btDevice: BluetoothDevice): Boolean {
        val createBondMethod = btClass.getMethod("createBond")
        val returnValue = createBondMethod.invoke(btDevice) as Boolean
        return returnValue
    }

    //取消配对
    @Throws(Exception::class)
    fun removeBond(btClass: Class<*>, btDevice: BluetoothDevice): Boolean {
        val removeBondMethod = btClass.getMethod("removeBond")
        val returnValue = removeBondMethod.invoke(btDevice) as Boolean
        return returnValue
    }

    @Throws(Exception::class)
    fun setPin(btClass: Class<out BluetoothDevice>, btDevice: BluetoothDevice,
               str: String): Boolean {
        try {
            val removeBondMethod = btClass.getDeclaredMethod("setPin",
                    *arrayOf<Class<*>>(ByteArray::class.java))
            val returnValue = removeBondMethod.invoke(btDevice,
                    arrayOf<Any>(str.toByteArray())) as Boolean
            Log.e("returnValue", "" + returnValue)
        } catch (e: SecurityException) {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace()
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
        return true
    }

    // 取消用户输入
    @Throws(Exception::class)
    fun cancelPairingUserInput(btClass: Class<*>,
                               device: BluetoothDevice): Boolean {
        val createBondMethod = btClass.getMethod("cancelPairingUserInput")
        //        cancelBondProcess(btClass, device);
        val returnValue = createBondMethod.invoke(device) as Boolean
        return returnValue
    }

    // 取消配对


    @Throws(Exception::class)
    fun cancelBondProcess(btClass: Class<*>,
                          device: BluetoothDevice): Boolean {
        val createBondMethod = btClass.getMethod("cancelBondProcess")
        val returnValue = createBondMethod.invoke(device) as Boolean
        return returnValue
    }

    //确认配对

    @Throws(Exception::class)
    fun setPairingConfirmation(btClass: Class<*>, device: BluetoothDevice, isConfirm: Boolean) {
        val setPairingConfirmation = btClass.getDeclaredMethod("setPairingConfirmation", Boolean::class.javaPrimitiveType)
        setPairingConfirmation.invoke(device, isConfirm)
    }


    /**
     *
     * @param clsShow
     */
    fun printAllInform(clsShow: Class<*>) {
        try {
            // 取得所有方法
            val hideMethod = clsShow.methods
            var i = 0
            while (i < hideMethod.size) {
                Log.e("method name", hideMethod[i].name + ";and the i is:"
                        + i)
                i++
            }
            // 取得所有常量
            val allFields = clsShow.fields
            i = 0
            while (i < allFields.size) {
                Log.e("Field name", allFields[i].name)
                i++
            }
        } catch (e: SecurityException) {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace()
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

    }
}