package com.af.abner_af_im.provider

import android.app.Application
import com.af.abner_af_im.coroutine.ChatCoroutineScope
import com.af.abner_af_im.state.ActionResult
import com.af.abner_af_im.state.ServerState
import com.af.abner_af_im.utils.AppConstant
import com.af.abner_af_im.utils.GenerateUserSig
import com.tencent.imsdk.v2.V2TIMCallback
import com.tencent.imsdk.v2.V2TIMManager
import com.tencent.imsdk.v2.V2TIMSDKConfig
import com.tencent.imsdk.v2.V2TIMSDKListener
import com.tencent.imsdk.v2.V2TIMUserFullInfo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * @Author: leavesCZY
 * @Desc:
 * @Github：https://github.com/leavesCZY
 */
class AccountProvider : IAccountProvider {

    override val serverConnectState = MutableSharedFlow<ServerState>()

    override fun init(application: Application) {
        val config = V2TIMSDKConfig()
        config.logLevel = V2TIMSDKConfig.V2TIM_LOG_WARN
        V2TIMManager.getInstance().addIMSDKListener(object : V2TIMSDKListener() {

            override fun onConnecting() {
                updateServerState(serverState = ServerState.Connecting)
            }

            override fun onConnectSuccess() {
                updateServerState(serverState = ServerState.Connected)
            }

            override fun onConnectFailed(code: Int, error: String) {
                updateServerState(serverState = ServerState.ConnectFailed)
            }

            override fun onUserSigExpired() {
                updateServerState(serverState = ServerState.UserSigExpired)
            }

            override fun onKickedOffline() {
                updateServerState(serverState = ServerState.KickedOffline)
            }

            override fun onSelfInfoUpdated(info: V2TIMUserFullInfo) {
            }
        })
        V2TIMManager.getInstance().initSDK(application, AppConstant.APP_ID, config)
    }

    private fun updateServerState(serverState: ServerState) {
        ChatCoroutineScope.launch {
            serverConnectState.emit(value = serverState)
        }
    }

    override suspend fun login(userId: String): ActionResult {
        val formatUserId = userId.lowercase()
        return suspendCancellableCoroutine { continuation ->
            V2TIMManager.getInstance().login(
                formatUserId,
                GenerateUserSig.genUserSig(userId = formatUserId),
                object : V2TIMCallback {
                    override fun onSuccess() {
                        continuation.resume(value = ActionResult.Success)
                    }

                    override fun onError(code: Int, desc: String?) {
                        continuation.resume(
                            value = ActionResult.Failed(
                                code = code,
                                reason = desc ?: ""
                            )
                        )
                    }
                })
        }
    }

    override suspend fun logout(): ActionResult {
        return suspendCancellableCoroutine { continuation ->
            V2TIMManager.getInstance().logout(
                object : V2TIMCallback {
                    override fun onSuccess() {
                        updateServerState(serverState = ServerState.Logout)
                        continuation.resume(value = ActionResult.Success)
                    }

                    override fun onError(code: Int, desc: String?) {
                        continuation.resume(
                            value = ActionResult.Failed(
                                code = code,
                                reason = desc ?: ""
                            )
                        )
                    }
                }
            )
        }
    }


}