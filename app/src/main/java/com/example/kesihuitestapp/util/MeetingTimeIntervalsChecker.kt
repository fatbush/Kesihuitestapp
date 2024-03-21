package com.example.kesihuitestapp.util

import android.util.Log
import java.lang.StringBuilder


class MeetingTimeIntervalsChecker {

    private val TAG = this.javaClass.simpleName

    fun check(srcArrays: Array<Array<Int>>): Boolean? {
        if (!verifyArray(srcArrays)) {
            return null
        }
        //1、copy a new arrays to process, avoid to process the source arrays directly
        val processArray = srcArrays.copyOf()
        //2、sort arrays in ascending by first element
        processArray.sortWith(compareBy { it[0] })
        //3、check again for debug
        ArrayPrinter.printGenerateArray(srcArrays)
        ArrayPrinter.printGenerateArray(processArray)
        //4、core code If the start of element[0] less than the end time of the previous element[1],
        for (index in 0 until processArray.size - 1) {
            if (processArray[index][1] > processArray[index + 1][0]) {
                return false
            }
        }
        return true
    }

    private fun verifyArray(srcArrays: Array<Array<Int>>): Boolean {
        if (srcArrays.isEmpty()) {
            Log.e(TAG, "meeting time intervals arrays is Empty")
            return false
        }

        for (row in srcArrays) {
            if (row.size != 2) {
                Log.e(TAG, "meeting time intervals size must be 2")
                return false
            }

            if (row[0] < 0 || row[1] < 0) {
                Log.e(TAG, "meeting time intervals arrays value cannot be less than zero")
                return false
            }

            if (row[1] < row[0]) {
                Log.e(TAG, "meeting time intervals arrays value error")
                return false
            }
        }
        return true
    }
}