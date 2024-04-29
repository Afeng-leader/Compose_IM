package com.af.abner_af_im.utils

import android.util.Log

object LogUtils {
    private val isDebug: Boolean = true
    private val TAG: String = "日常打log"

    fun i(msg: String) {
        if (isDebug) {
            Log.i(TAG, msg)
        }
    }

    fun d(msg: String) {
        if (isDebug) {
            Log.d(TAG, msg)
        }
    }


    fun e(msg: String) {
        if (isDebug) {
            Log.e(TAG, msg)
        }
    }

    fun v(msg: String) {
        if (isDebug) {
            Log.v(TAG, msg)
        }
    }
}
