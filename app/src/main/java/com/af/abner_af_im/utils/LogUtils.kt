package com.af.abner_af_im.utils

import android.util.Log

object LogUtils {
    private const val isDebug: Boolean = true
    private const val TAG = "Composable_IM"

    fun i(tag: String ,msg: String) {
        if (isDebug) {
            Log.i(TAG,"$tag:  $msg")
        }
    }

    fun d(tag: String ,msg: String) {
        if (isDebug) {
            Log.d(TAG,"$tag:  $msg")
        }
    }


    fun e(tag: String ,msg: String) {
        if (isDebug) {
            Log.e(TAG,"$tag:  $msg")
        }
    }

    fun v(tag: String ,msg: String) {
        if (isDebug) {
            Log.v(TAG,"$tag:  $msg")
        }
    }
}
