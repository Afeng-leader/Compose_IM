package com.af.abner_af_im.ui.main

import androidx.lifecycle.viewModelScope
import com.af.abner_af_im.provider.LastLoginAccountProvider
import com.af.abner_af_im.state.ActionResult
import com.af.abner_af_im.ui.login.ComposeChat
import github.leavesczy.compose_chat.ui.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel : BaseViewModel() {


     fun logout() : Boolean{
        viewModelScope.launch {
            when (val result = ComposeChat.accountProvider.logout()) {
                is ActionResult.Success -> {
                    LastLoginAccountProvider.onUserLogout()
                    delay(timeMillis = 250)
                }

                is ActionResult.Failed -> {
                    showToast(msg = result.reason)
                }
            }
        }
         return true

     }



}