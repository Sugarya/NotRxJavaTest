package com.sugarya.notrxjavatest2.version4

import android.net.Uri
import com.sugarya.notrxjavatest2.BaseCatsHelper
import com.sugarya.notrxjavatest2.Cat
import com.sugarya.notrxjavatest2.version3.Callback

/**
 * Created by Ethan on 2018/4/6.
 */
class CatsHelper4(val apiWrapper: ApiWrapper) : BaseCatsHelper(){

    fun saveTheCutestCar(query: String): AsyncJob4<Uri>{
        return object : AsyncJob4<Uri>(){
            override fun start(callback: Callback<Uri>) {
                val queryCatsJob = apiWrapper.queryCats(query)
                queryCatsJob.start(object : Callback<List<Cat>>{
                    override fun onResult(t: List<Cat>) {
                        val cutest = findCutest(t)
                        val storeCatJob = apiWrapper.store(cutest)
                        storeCatJob.start(object : Callback<Uri>{
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
    }
}