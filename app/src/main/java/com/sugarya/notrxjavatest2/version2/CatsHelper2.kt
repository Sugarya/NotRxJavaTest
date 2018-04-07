package com.sugarya.notrxjavatest2.version2

import android.net.Uri
import com.sugarya.notrxjavatest2.BaseCatsHelper
import com.sugarya.notrxjavatest2.Cat

/**
 * Created by Ethan on 2018/4/6.
 */
class CatsHelper2(val api: Api) : BaseCatsHelper(){

    interface CutestCarCallBack {

        fun onCutestCarSaved(uri: Uri)

        fun onError(e: Exception)
    }

    fun saveTheCutestCar(query: String, cutestCarCallBack: CutestCarCallBack) {
         api.queryCats(query, object : Api.CatsQueryCallback{
             override fun onCatListReceived(cats: List<Cat>) {
                 val cat = findCutest(cats)
                 api.store(cat, object : Api.StoreCallback{
                     override fun onCatStore(uri: Uri) {
                         cutestCarCallBack.onCutestCarSaved(uri)
                     }

                     override fun onStoreFailed(e: Exception) {
                         cutestCarCallBack.onError(e)
                     }
                 })
             }

             override fun onQueryFailed(e: Exception) {
                 cutestCarCallBack.onError(e)
             }
         })
    }


}