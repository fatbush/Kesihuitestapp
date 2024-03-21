package com.example.kesihuitestapp.util

import android.util.Log
import java.lang.StringBuilder

/**
 * @Desc    : 描述……
 * @author  : Tony
 * @E-mail  : wuyuhang@baibu.la
 * @Date    : 2024-03-21 16:51
 * @Version ： 1.0
 */
class ArrayPrinter {

    companion object {

        fun printGenerateArray(srcArray: Array<Array<Int>>) {
            Log.v(javaClass.simpleName, "------")
            for (row in srcArray) {
                val stringBuilder = StringBuilder("[")
                for ((index, item) in row.withIndex()) {
                    stringBuilder.append("$item")
                    if (index < row.size - 1) {
                        stringBuilder.append(",")
                    }
                }
                stringBuilder.append("]\n")
                Log.v(javaClass.simpleName, stringBuilder.toString())
            }
            Log.v(javaClass.simpleName, "======\n")
        }
    }
}