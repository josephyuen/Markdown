package com.nzf.markdown.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import android.text.TextUtils
import android.util.Log
import com.nzf.markdown.R
import com.nzf.markdown.app.MDApplication
import com.nzf.markdown.bean.MDFileBean
import org.jetbrains.annotations.NotNull
import java.io.*

/**
 * Created by niezhuofu on 17-11-7.
 */
class FilesUtils {
    private var mContext: Context? = null
    lateinit var nowPath: String

    val FILEDIR_EXTERNAL: String = "ExternalFileDir"
    val FILEDIR_INTERNAL: String = "InternalFileDir"

    init {
        mContext = MDApplication.getContext()
    }

    companion object {
        private val TAG = "FilesUtils"

        val FILETYPE_DIR: Int = 0
        val FILETYPE_MD: Int = 1
        val FILETYPE_HTML: Int = 2

        val FILE_MD: String = ".md"
        val FILE_HTML: String = ".html"

        val instance: FilesUtils
            get() = SingletonHolder.INSTANCE

        private object SingletonHolder {
            @SuppressLint("StaticFieldLeak")
            val INSTANCE = FilesUtils()
        }
    }

    //生成MD文件
    fun newMDFile(pathName: String): Boolean {
        var file = File(nowPath + pathName)
        var isCreate = false

        if (file.exists()) {
            ToastUtils.showShort(R.string.file_exists)
            return isCreate
        }

        return try {
            isCreate = file.createNewFile()
            if(!isCreate){
                ToastUtils.showShort(R.string.file_exists)
            }
            isCreate
        } catch (e: IOError) {
            ToastUtils.showShort("Invalid file path")
            false
        }
    }

    // 生成文件夹
    fun mkFileDir(pathName: String): Boolean {
        var file = File(nowPath + pathName)
        var isCreate = false

        if (file.exists()) {
            ToastUtils.showShort(R.string.file_exists)
            return isCreate
        }

        isCreate = file.mkdir()
        return isCreate
    }

    /**
     * 删除单个文件
     *
     * @param file
     *            要删除的文件对象
     * @return 文件删除成功则返回true
     */
    private fun deleteFile(file: File): Boolean {
        var isDelete = false

        return if (file.exists()) {
            isDelete = file.delete()
            Log.i("FileUtils:", "file delete.")
            isDelete
        } else {
            Log.i("FileUtils:", "file is null")
            ToastUtils.showShort(R.string.file_noexists)
            isDelete
        }
    }


    /**
     * 删除文件夹及其包含的所有文件
     *
     * @param file
     * @return
     */
    private fun deleteFolder(file: File): Boolean {
        var flag: Boolean
        val files: Array<File>? = file.listFiles()
        if (files != null && files.size >= 0)
        // 目录下存在文件列表
        {
            files.indices
                    .asSequence()
                    .map { files[it] }
                    .forEach {
                        if (it.isFile) {
                            // 删除子文件
                            flag = deleteFile(it)
                            if (!flag) {
                                return flag
                            }
                        } else {
                            // 删除子目录
                            flag = deleteFolder(it)
                            if (!flag) {
                                return flag
                            }
                        }
                    }
        }
        flag = file.delete()
        return if (!flag) {
            flag
        } else {
            true
        }
    }

    /**
     * 展示所有文件
     * @param path  需要展示的路径
     * @return ArrayList<MDFileBean> 当前路径MD文件集合
     */
    fun showAllMDDir(path: String?): ArrayList<MDFileBean>? {
        var file = File(path)

        var filesList: java.util.ArrayList<MDFileBean>? = ArrayList()

        var files: Array<File> = file.listFiles()

        if (files.isNotEmpty()) {
            files.mapNotNull { getMDFile(it) }.forEach { filesList!!.add(it) }
        }

        return filesList
    }

    val FILETYPE_DIR: Int = 0
    val FILETYPE_MD: Int = 1
    val FILETYPE_HTML: Int = 2

    /**
     * 判断是否是MD文件
     * @param f  文件对象
     * @return ArrayList<MDFileBean> 当前路径MD文件集合
     */
    private fun getMDFile(f: File): MDFileBean? {
        var bean: MDFileBean? = MDFileBean()
        var fileName: String = f.name

        bean!!.fileName = f.name
        bean.fileLastTime = f.lastModified()
        bean.fileSize = f.length()
        bean.filePath = f.path


        Log.i(TAG,f.name + "--" + f.isDirectory)


        if (f.isFile) {
            var fileSuffix: String = getFileSuffix(fileName)


            when (fileSuffix) {
                FILE_MD -> bean.fileType = FILETYPE_MD
                FILE_HTML -> bean.fileType = FILETYPE_HTML
                else -> bean = null
            }
        }

        if (f.isDirectory) {
            bean!!.fileType = FILETYPE_DIR
        }

        return bean
    }

    /**
     * 复制文件
     *
     * @param srcPath 源文件绝对路径
     * @param targetDir 目标文件所在目录
     * @return boolean
     */
    fun copyFile(srcPath: String, targetDir: String): Boolean {
        var flag = false
        var file = File(srcPath)

        if (!file.exists()) {
            ToastUtils.showShort(R.string.file_noexists)
            return flag
        }

        var fileName: String = srcPath.substring(srcPath.lastIndexOf(File.separator))
        var targetPath: String = targetDir + fileName

        if (targetPath.equals(srcPath)) {
            ToastUtils.showShort(R.string.file_exists)
            return flag
        }

        var targetFile = File(targetPath)
        if (targetFile.exists() && targetFile.isFile) {
            ToastUtils.showShort(R.string.file_exists)
            return flag
        }

        try {
            val fis = FileInputStream(srcPath)
            val fos = FileOutputStream(targetFile)
            val buf = ByteArray(1024)
            var c: Int
            do {
                c = fis.read(buf)
                fos.write(buf, 0, c)
            } while (c != -1)
            fis.close()
            fos.close()

            flag = true
        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (flag) {
            ToastUtils.showShort(R.string.file_copy)
        }
        return flag
    }

    /**
     * 根据文件名获得文件的扩展名
     *
     * @param fileName 文件名
     * @return 文件扩展名
     */
    private fun getFileSuffix(fileName: String): String {
         if(!fileName.contains(".")){
             return ""
         }
         var index: Int = fileName.lastIndexOf(".")
         var fileSuffix: String = fileName.substring(index, fileName.length)
         return fileSuffix
    }

    /**
     * 获取应用文件夹
     * @param path  存储类型(FILEDIR_EXTERNAL:外部存储,FILEDIR_INTERNAL内部存储)
     * @param type 需要获取的路径,
     * @return File
     */
    fun getFileDirectory(@NotNull path: String, type: String?): File? {
        var mdFileDir: File? = null
        when (path) {
            FILEDIR_EXTERNAL -> mdFileDir = getExternalFileDirectory(type)
            FILEDIR_INTERNAL -> mdFileDir = getInternalFileDirectory(type)
        }

        if (mdFileDir == null) {
            Log.i("getFileDirectory", "getExternalFileDirectory fail,the reason is sdCard nonexistence or sdCard mount fail !")
            mdFileDir = getInternalFileDirectory(type)
        }

        if (mdFileDir == null) {
            Log.e("getFileDirectory", "getFileDirectory fail ,the reason is mobile phone unknown exception !")
        } else {
            if (!mdFileDir.exists() && !mdFileDir.mkdirs()) {
                Log.e("getFileDirectory", "getFileDirectory fail ,the reason is make directory fail !")
            }
        }
        nowPath = mdFileDir!!.path
        return mdFileDir
    }

    /**
     *type为空获取File文件夹根目录
     */
    private fun getInternalFileDirectory(type: String?): File? {
        var mdFileDir: File?
        if (TextUtils.isEmpty(type)) {
            mdFileDir = mContext!!.filesDir
        } else {
            mdFileDir = File(mContext!!.filesDir, type)
        }


        if (!mdFileDir!!.exists() && !mdFileDir.mkdirs()) {
            Log.i("FileUtils",
                    "getInternalDirectory fail ,the reason is make directory fail !")
        }
        return mdFileDir
    }

    /**
     *type为空获取File文件夹根目录
     */
    private fun getExternalFileDirectory(type: String?): File? {
        var mdFileDir: File? = null
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            if (TextUtils.isEmpty(type)) {
                mdFileDir = Environment.getExternalStorageDirectory()
            } else {
                mdFileDir = File (Environment.getExternalStorageDirectory().absolutePath,type)
            }
        } else {
            Log.i("FileUtils", "getExternalDirectory fail ,the reason is sdCard nonexistence or sdCard mount fail !")
        }
        return mdFileDir
    }



}