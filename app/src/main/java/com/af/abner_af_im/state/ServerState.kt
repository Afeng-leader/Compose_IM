package com.af.abner_af_im.state

import androidx.compose.runtime.Stable


@Stable
sealed class ActionResult {

    data object Success : ActionResult()

    data class Failed(val code: Int, val reason: String) : ActionResult() {

        constructor(reason: String) : this(code = -1, reason = reason)

    }

}

@Stable
enum class ServerState {
    Logout,
    Connecting,
    Connected,
    ConnectFailed,
    UserSigExpired,
    KickedOffline
}