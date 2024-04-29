package com.af.abner_af_im

import android.app.Application
import com.af.abner_af_im.provider.LastLoginAccountProvider
import com.af.abner_af_im.provider.AppThemeProvider
import com.af.abner_af_im.provider.ContextProvider
import com.af.abner_af_im.provider.ToastProvider
import com.af.abner_af_im.ui.login.ComposeChat

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextProvider.init(this)
        ToastProvider.init(this)
        AppThemeProvider.init(this)
        LastLoginAccountProvider.init(this)
        ComposeChat.accountProvider.init(this)

    }
}