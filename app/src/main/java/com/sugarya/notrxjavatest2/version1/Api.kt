package com.sugarya.notrxjavatest2.version1

import android.net.Uri
import com.sugarya.notrxjavatest2.Cat

/**
 * Created by Ethan on 2018/4/6.
 * 同步／阻塞式API
 */
interface Api{

    fun queryCats(query: String): List<Cat>

    fun store(cat: Cat): Uri

}