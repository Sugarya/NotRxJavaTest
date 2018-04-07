package com.sugarya.notrxjavatest2

import java.util.*

/**
 * Created by Ethan on 2018/4/6.
 */
open class BaseCatsHelper{

    fun findCutest(cats: List<Cat>): Cat {
        return Collections.max(cats)
    }
}