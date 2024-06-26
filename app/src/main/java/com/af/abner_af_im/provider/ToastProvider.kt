package com.af.abner_af_im.provider

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast

object ToastProvider {

    private lateinit var context: Application

    private val handler by lazy(mode = LazyThreadSafetyMode.NONE) {
        Handler(Looper.getMainLooper())
    }

    internal fun init(application: Application) {
        context = application
    }

    fun showToast(resId: Int) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            handler.post {
                showToast(context, context.resources.getString(resId))
            }
        } else {
            showToast(context, context.resources.getString(resId))
        }
    }

    fun showToast(msg: String) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            handler.post {
                showToast(context, msg)
            }
        } else {
            showToast(context, msg)
        }
    }

    private fun showToast(context: Context, msg: String) {
        val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
        hookToastIfNeed(toast)
        toast.show()
    }

    @SuppressLint("DiscouragedPrivateApi")
    private fun hookToastIfNeed(toast: Toast) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1) {
            try {
                val cToast = Toast::class.java
                val fTn = cToast.getDeclaredField("mTN")
                fTn.isAccessible = true
                val oTn = fTn.get(toast)
                val cTn = oTn.javaClass
                val fHandle = cTn.getDeclaredField("mHandler")
                fHandle.isAccessible = true
                fHandle.set(oTn, ProxyHandler(fHandle.get(oTn) as Handler))
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    private class ProxyHandler(private val mHandler: Handler) : Handler(mHandler.looper) {

        override fun handleMessage(msg: Message) {
            try {
                mHandler.handleMessage(msg)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }

    }

}