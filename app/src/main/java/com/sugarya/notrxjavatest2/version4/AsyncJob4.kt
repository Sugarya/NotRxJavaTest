package com.sugarya.notrxjavatest2.version4

import com.sugarya.notrxjavatest2.version3.Callback

/**
 * Created by Ethan on 2018/4/6.
 */
abstract class AsyncJob4<T>{
    abstract fun start(callback: Callback<T>)
}