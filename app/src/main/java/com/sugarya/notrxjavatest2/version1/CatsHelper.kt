package com.sugarya.notrxjavatest2.version1

import android.net.Uri
import com.sugarya.notrxjavatest2.BaseCatsHelper

/**
 * Created by Ethan on 2018/4/6.
 */
class CatsHelper(val api: Api) : BaseCatsHelper(){

    fun saveTheCutestCar(query: String): Uri {
        return try {
            val queryCats = api.queryCats(query)
            val cat = findCutest(queryCats)
            api.store(cat)
        } catch (e: Exception) {
            e.printStackTrace()
            Uri.parse("")
        }
    }

}