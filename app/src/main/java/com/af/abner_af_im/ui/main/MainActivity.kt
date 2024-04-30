package com.af.abner_af_im.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.af.abner_af_im.base.BaseActivity
import com.af.abner_af_im.state.ServerState
import com.af.abner_af_im.ui.login.LoginActivity
import kotlinx.coroutines.launch


class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainPage()
        }

        initEvent()
    }

    private fun initEvent() {

        lifecycleScope.launch {
            mainViewModel.serverConnectState.collect{
                when(it) {
                    ServerState.Logout -> {
                        startActivity<LoginActivity>()
                        finish()
                    }

                    else -> {}
                }
            }
        }
    }

    @Preview
    @Composable
    fun MainPage() {
        Button(
            content = { Text("退出登录") },
            onClick = {
                mainViewModel.logout()
            })
    }
}


