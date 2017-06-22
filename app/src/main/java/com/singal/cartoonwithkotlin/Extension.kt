package com.singal.cartoonwithkotlin

import android.content.Context
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import com.squareup.okhttp.Request
import javax.xml.datatype.Duration

/**
 * 常用方法类
 *
 * Created by li on 2017/6/22.
 */
fun Context.toast(message:String,duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}

fun View.snackBar(message: String,duration: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(this,message,duration).show()
}

fun View.snackBar(messageRes: Int,duration: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(this,messageRes,duration).show()
}

fun Any.log(message: String){
    Log.e(this.javaClass.simpleName,message)
}

/**
 * 获取 html 数据
 */
fun getHtml(url : String): String{
    val client = OkClient.instance()
    val request = Request.Builder()
            .url(url)
            .build()
    val response = client.newCall(request).execute()

    return response.body().string()
}


fun WebView.load(html : String){
    this.loadDataWithBaseURL("http:ishuhui.net/",html,"text/html","charset=utf-8",null)
}






