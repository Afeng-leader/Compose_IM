package com.af.abner_af_im.provider

import android.app.Application

/**
 * @Author: leavesCZY
 * @Desc:
 * @Github：https://github.com/leavesCZY
 */
object ContextProvider {

    lateinit var context: Application
        private set

    fun init(application: Application) {
        context = application
    }

}