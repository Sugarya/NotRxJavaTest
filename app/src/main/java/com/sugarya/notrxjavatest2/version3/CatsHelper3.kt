package com.sugarya.notrxjavatest2.version3

import android.net.Uri
import com.sugarya.notrxjavatest2.BaseCatsHelper
import com.sugarya.notrxjavatest2.Cat

/**
 * Created by Ethan on 2018/4/6.
 *
 */
class CatsHelper3(val apiWrapper: ApiWrapper) : BaseCatsHelper(){


    fun saveTheCutestCar(query: String, callback: Callback<Uri>){
        apiWrapper.queryCats(query, object : Callback<List<Cat>>{
            override fun onResult(t: List<Cat>) {
                apiWrapper.store(findCutest(t), callback)
            }

            override fun onError(e: Exception) {
                callback.onError(e)
            }
        })
    }

}