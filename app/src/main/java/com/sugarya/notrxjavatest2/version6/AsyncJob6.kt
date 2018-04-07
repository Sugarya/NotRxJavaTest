package com.sugarya.notrxjavatest2.version6

import com.sugarya.notrxjavatest2.version3.Callback

/**
 * Created by Ethan on 2018/4/6.
 * 加入map
 */
abstract class AsyncJob6<T> {

    abstract fun start(callback: Callback<T>)

    fun <R> map(func: Func<T, R>): AsyncJob6<R> {
        return object : AsyncJob6<R>() {
            override fun start(callback: Callback<R>) {
                this@AsyncJob6.start(object : Callback<T> {
                    override fun onResult(t: T) {
                        val r = func.call(t)
                        callback.onResult(r)
                    }

                    override fun onError(e: Exception) {
                        callback.onError(e)
                    }
                })
            }
        }
    }

    fun <R> flatMap(func2: (T) -> AsyncJob6<R>): AsyncJob6<R> {
        return object : AsyncJob6<R>() {
            override fun start(callback: Callback<R>) {
                this@AsyncJob6.start(object : Callback<T> {
                    override fun onResult(t: T) {
                        val asyncJob6 = func2.invoke(t)
                        asyncJob6.start(object : Callback<R> {
                            override fun onResult(t: R) {
                                callback.onResult(t)
                            }

                            override fun onError(e: Exception) {
                                callback.onError(e)
                            }
                        })
                    }

                    override fun onError(e: Exception) {
                        callback.onError(e)
                    }
                })
            }
        }
    }

    fun <R> map2(func: (T) -> R): AsyncJob6<R> {
        return object : AsyncJob6<R>() {
            override fun start(callback: Callback<R>) {
                this@AsyncJob6.start(object : Callback<T> {
                    override fun onResult(t: T) {
                        val r = func.invoke(t)
                        callback.onResult(r)
                    }

                    override fun onError(e: Exception) {
                        callback.onError(e)
                    }
                })
            }
        }
    }
}