package com.af.abner_af_im.ui.main

import androidx.lifecycle.viewModelScope
import com.af.abner_af_im.provider.LastLoginAccountProvider
import com.af.abner_af_im.state.ActionResult
import com.af.abner_af_im.state.ServerState
import com.af.abner_af_im.ui.login.ComposeChat
import github.leavesczy.compose_chat.ui.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch


class MainViewModel : BaseViewModel() {
    private val _serverConnectState = MutableStateFlow(value = ServerState.Connected)

    val serverConnectState: SharedFlow<ServerState> = _serverConnectState


    init {
        viewModelScope.launch{
            launch {
                ComposeChat.accountProvider.serverConnectState.collect{
                    _serverConnectState.emit(value = it)
                }
            }
        }
    }

     fun logout() : Boolean{
        viewModelScope.launch {
            when (val result = ComposeChat.accountProvider.logout()) {
                is ActionResult.Success -> {
                    LastLoginAccountProvider.onUserLogout()
                }

                is ActionResult.Failed -> {
                    showToast(msg = result.reason)
                }
            }
        }
         return true

     }



}