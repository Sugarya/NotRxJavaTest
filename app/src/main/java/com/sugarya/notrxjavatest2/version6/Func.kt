package com.sugarya.notrxjavatest2.version6

/**
 * Created by Ethan on 2018/4/6.
 */
interface Func<T, R> {
    fun call(t: T): R
}