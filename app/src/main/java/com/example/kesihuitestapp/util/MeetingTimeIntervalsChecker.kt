package com.example.kesihuitestapp.util

import android.util.Log


class MeetingTimeIntervalsChecker {

    private val TAG = this.javaClass.simpleName

    fun check(srcArrays: Array<Array<Int>>):Boolean? {
        if(srcArrays.isEmpty()){
            Log.e(TAG, "meeting time intervals arrays is Empty")
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
        for (index in 0 until processArray.size-1) {
            if(processArray[index][1] > processArray[index+1][0]){
                return false
            }
        }
        return true
    }

}