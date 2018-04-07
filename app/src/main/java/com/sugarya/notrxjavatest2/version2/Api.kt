package com.sugarya.notrxjavatest2.version2

import android.net.Uri
import com.sugarya.notrxjavatest2.Cat

/**
 * Created by Ethan on 2018/4/6.
 * 异步式API
 */
interface Api{

    interface CatsQueryCallback{

        fun onCatListReceived(cats: List<Cat>)

        fun onQueryFailed(e: Exception)
    }

    interface StoreCallback{

        fun onCatStore(uri: Uri)

        fun onStoreFailed(e: Exception)
    }


    fun queryCats(query: String, catsQueryCallback: CatsQueryCallback)

    fun store(cat: Cat, storeCallback: StoreCallback)
}