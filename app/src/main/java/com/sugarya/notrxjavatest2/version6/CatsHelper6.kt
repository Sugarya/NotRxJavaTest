package com.sugarya.notrxjavatest2.version6

import android.net.Uri
import com.sugarya.notrxjavatest2.BaseCatsHelper

/**
 * Created by Ethan on 2018/4/6.
 * 异步下的组合
 */
class CatsHelper6(val apiWrapper: ApiWrapper6) : BaseCatsHelper() {

    fun saveTheCutestCar(query: String): AsyncJob6<Uri> {
        val queryCatsAsyncJob = apiWrapper.queryCats(query)

        return queryCatsAsyncJob.map2 {
            findCutest(it)
        }.flatMap {
            apiWrapper.store(it)
        }
    }

}