package com.sugarya.notrxjavatest2

import android.graphics.Bitmap

/**
 * Created by Ethan on 2018/4/6.
 */
class Cat(val bitmap: Bitmap, val cuteness: Int): Comparable<Cat>{

    override fun compareTo(other: Cat): Int =  if(cuteness - other.cuteness >= 0) cuteness else 1

}