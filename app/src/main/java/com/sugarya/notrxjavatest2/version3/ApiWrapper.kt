package com.sugarya.notrxjavatest2.version3

import android.net.Uri
import com.sugarya.notrxjavatest2.Cat
import com.sugarya.notrxjavatest2.version2.Api

/**
 * Created by Ethan on 2018/4/6.
 * 引入泛型
 */
class ApiWrapper(private val api: Api){

    fun queryCats(query: String, callback: Callback<List<Cat>>){
        api.queryCats(query, object : Api.CatsQueryCallback{
            override fun onCatListReceived(cats: List<Cat>) {
                callback.onResult(cats)
            }

            override fun onQueryFailed(e: Exception) {
                callback.onError(e)
            }
        })
    }

    fun store(cat: Cat, callback: Callback<Uri>){
        api.store(cat, object : Api.StoreCallback{
            override fun onCatStore(uri: Uri) {
                callback.onResult(uri)
            }

            override fun onStoreFailed(e: Exception) {
                callback.onError(e)
            }
        })
    }

}