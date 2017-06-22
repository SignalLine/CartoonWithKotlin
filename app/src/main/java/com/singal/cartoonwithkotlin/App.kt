package com.singal.cartoonwithkotlin

import android.app.Application
import android.util.Log
import com.squareup.picasso.LruCache
import com.squareup.picasso.Picasso

/**
 * app
 *
 * Created by li on 2017/6/22.
 */
class App : Application(){
    private val TAG = App::class.java.simpleName

    override fun onCreate() {
        super.onCreate()

        Log.i(TAG,"app ----- onCreate");

        val maxMem = Runtime.getRuntime().maxMemory().toInt();
        Picasso.Builder(this).memoryCache(LruCache(maxMem / 8)).build()
    }
}