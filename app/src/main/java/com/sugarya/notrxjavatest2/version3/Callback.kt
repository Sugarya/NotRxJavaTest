package com.sugarya.notrxjavatest2.version3

/**
 * Created by Ethan on 2018/4/6.
 */
interface Callback<T>{

    fun onResult(t: T)

    fun onError(e: Exception)
}