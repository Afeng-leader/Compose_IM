package com.af.abner_af_im.provider

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

object LastLoginAccountProvider {

    private const val KEY_GROUP = "AccountGroup"
    private const val KEY_LAST_LOGIN_USER_ID = "KeyLastLoginUserId"
    private const val KEY_LAST_LOGIN_AVATAR = "KeyLastLoginAvatar"
    private const val KEY_LAST_LOGIN_NICK_NAME = "KeyLastLoginNickname"
    private const val KEY_AUTO_LOGIN = "KeyAutoLogin"
    // 是否有账号登录过
    private const val KEY_ACCOUNT_LOGIN = "KeyAccountLogin"

    private lateinit var sharedPreferences: SharedPreferences

    fun init(application: Application) {
        sharedPreferences = application.getSharedPreferences(KEY_GROUP, Context.MODE_PRIVATE)
    }

    val lastLoginUserId: String
        get() = sharedPreferences.getString(KEY_LAST_LOGIN_USER_ID, "") ?: ""

    var accountLogin: Boolean
        get() = sharedPreferences.getBoolean(KEY_ACCOUNT_LOGIN, false)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_ACCOUNT_LOGIN, value).apply()
        }

    val canAutoLogin: Boolean
        get() = sharedPreferences.getBoolean(KEY_AUTO_LOGIN, true)

    fun onUserLogin(userId: String) {
        sharedPreferences.edit().apply {
            putString(KEY_LAST_LOGIN_USER_ID, userId)
            putBoolean(KEY_AUTO_LOGIN, true)
            putBoolean(KEY_ACCOUNT_LOGIN, false)
            apply()
        }
    }

    fun onUserLogout() {
        sharedPreferences.edit().apply {
            putBoolean(KEY_AUTO_LOGIN, false)
            putBoolean(KEY_ACCOUNT_LOGIN, true)
            apply()
        }
    }
}