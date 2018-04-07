package com.sugarya.notrxjavatest2.version6

import android.net.Uri
import com.sugarya.notrxjavatest2.Cat
import com.sugarya.notrxjavatest2.version2.Api
import com.sugarya.notrxjavatest2.version3.Callback

/**
 * Created by Ethan on 2018/4/6.
 * 带返回值的异步
 */
class ApiWrapper6(private val api: Api) {

    fun queryCats(query: String): AsyncJob6<List<Cat>> {
        return object : AsyncJob6<List<Cat>>() {
            override fun start(callback: Callback<List<Cat>>) {
                api.queryCats(query, object : Api.CatsQueryCallback {
                    override fun onCatListReceived(cats: List<Cat>) {
                        callback.onResult(cats)
                    }

                    override fun onQueryFailed(e: Exception) {
                        callback.onError(e)
                    }
                })
            }
        }
    }

    fun store(cat: Cat): AsyncJob6<Uri> {
        return object : AsyncJob6<Uri>() {
            override fun start(callback: Callback<Uri>) {
                api.store(cat, object : Api.StoreCallback {
                    override fun onCatStore(uri: Uri) {
                        callback.onResult(uri)
                    }

                    override fun onStoreFailed(e: Exception) {
                        callback.onError(e)
                    }
                })
            }
        }
    }

}