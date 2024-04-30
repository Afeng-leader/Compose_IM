package com.af.abner_af_im.provider

import android.app.Application
import com.af.abner_af_im.state.ActionResult
import com.af.abner_af_im.state.ServerState
import kotlinx.coroutines.flow.SharedFlow


interface IAccountProvider {


    val serverConnectState: SharedFlow<ServerState>

    fun init(application: Application)

    suspend fun login(userId: String): ActionResult

    suspend fun logout(): ActionResult

}