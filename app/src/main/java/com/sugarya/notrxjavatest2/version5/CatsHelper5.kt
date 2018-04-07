package com.sugarya.notrxjavatest2.version5

import android.net.Uri
import com.sugarya.notrxjavatest2.BaseCatsHelper
import com.sugarya.notrxjavatest2.Cat
import com.sugarya.notrxjavatest2.version3.Callback
import com.sugarya.notrxjavatest2.version4.ApiWrapper
import com.sugarya.notrxjavatest2.version4.AsyncJob4

/**
 * Created by Ethan on 2018/4/6.
 * 异步下的组合
 */
class CatsHelper5(val apiWrapper: ApiWrapper) : BaseCatsHelper() {

    fun saveTheCutestCar(query: String): AsyncJob4<Uri> {

        val queryCatsAsyncJob = apiWrapper.queryCats(query)

        val cutestCatAsyncJob = object : AsyncJob4<Cat>() {
            override fun start(callback: Callback<Cat>) {
                queryCatsAsyncJob.start(object : Callback<List<Cat>> {
                    override fun onResult(t: List<Cat>) {
                        val cutest = findCutest(t)
                        callback.onResult(cutest)
                    }

                    override fun onError(e: Exception) {
                        callback.onError(e)
                    }
                })
            }
        }


        val uriAsyncJob = object : AsyncJob4<Uri>() {
            override fun start(callback: Callback<Uri>) {
                cutestCatAsyncJob.start(object : Callback<Cat> {
                    override fun onResult(t: Cat) {
                        val uriAsyncJob = apiWrapper.store(t)
                        uriAsyncJob.start(object : Callback<Uri> {
                            override fun onResult(t: Uri) {
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

        return uriAsyncJob
    }
}