package com.singal.cartoonwithkotlin.model

/**
 * Created by li on 2017/6/22.
 */
interface Source<T> {
    fun obtain(url: String): T
}