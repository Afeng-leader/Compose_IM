package com.af.abner_af_im.state

import androidx.compose.runtime.MutableState

data class LoginPageViewState(
    val isLoading: MutableState<Boolean>,
    val isShowLoginPage: MutableState<Boolean>,
    val lastLoginUserId: MutableState<String>
)