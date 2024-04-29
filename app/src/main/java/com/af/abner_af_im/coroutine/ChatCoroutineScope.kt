package com.af.abner_af_im.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob


internal object ChatCoroutineScope : CoroutineScope {

    /**
     *  SupervisorJob()是一个协程的监督者作业，它会监督其子协程的执行。当父协程被取消时，所有子协程也会被取消。
     *  Dispatchers.Main.immediate是一个协程调度器，它会在主线程上立即执行协程。这意味着协程会在主线程上立即执行，而不会被排队等待。
     */
    override val coroutineContext = SupervisorJob() + Dispatchers.Main.immediate

}