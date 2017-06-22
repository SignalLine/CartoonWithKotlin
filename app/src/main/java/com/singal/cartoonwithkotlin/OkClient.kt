package com.singal.cartoonwithkotlin

import com.squareup.okhttp.OkHttpClient

/**
 * 单例OkHttpClient
 *
 * Created by li on 2017/6/22.
 */
object OkClient {

    private val client = OkHttpClient()

    fun instance() = client

}