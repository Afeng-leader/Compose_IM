package com.af.abner_af_im.ui.login


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.af.abner_af_im.provider.LastLoginAccountProvider
import com.af.abner_af_im.state.ActionResult
import com.af.abner_af_im.state.LoginPageViewState
import github.leavesczy.compose_chat.ui.base.BaseViewModel
import kotlinx.coroutines.delay

class LoginViewModel : BaseViewModel() {

    val loginPageViewState by mutableStateOf(
        value = LoginPageViewState(
            lastLoginUserId = mutableStateOf(""),
            isLoading = mutableStateOf(false),
            isShowLoginPage = mutableStateOf(false)
        )
    )

    suspend fun tryLogin() : Boolean {
        return if (LastLoginAccountProvider.lastLoginUserId.isBlank() || !LastLoginAccountProvider
            .canAutoLogin) {
            loginPageViewState.lastLoginUserId.value = LastLoginAccountProvider.lastLoginUserId
            loginPageViewState.isShowLoginPage.value = true
            loginPageViewState.isLoading.value = false
            false
        } else {
            loginPageViewState.lastLoginUserId.value = LastLoginAccountProvider.lastLoginUserId
            loginPageViewState.isShowLoginPage.value = false
            loginPageViewState.isLoading.value = true
            login(userId = LastLoginAccountProvider.lastLoginUserId)
        }
    }

    suspend fun onLoginButtonClick(userId: String): Boolean {
        loginPageViewState.lastLoginUserId.value = userId
        loginPageViewState.isLoading.value = true
        return login(userId = userId)
    }

    private suspend fun login(userId: String): Boolean {
        val formatUserId = userId.lowercase()
        return when (val loginResult = ComposeChat.accountProvider.login(userId = formatUserId)) {
            is ActionResult.Success -> {
                LastLoginAccountProvider.onUserLogin(userId = formatUserId)
                delay(timeMillis = 250)
                true
            }
            is ActionResult.Failed -> {
                showToast(msg = loginResult.reason)
                loginPageViewState.lastLoginUserId.value = formatUserId
                loginPageViewState.isShowLoginPage.value = true
                loginPageViewState.isLoading.value = false
                false
            }
        }

    }

}