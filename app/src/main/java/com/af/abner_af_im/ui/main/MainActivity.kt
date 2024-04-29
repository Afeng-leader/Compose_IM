package com.af.abner_af_im.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.af.abner_af_im.base.BaseActivity
import com.af.abner_af_im.ui.login.ComposeChat
import com.af.abner_af_im.ui.login.LoginActivity


class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainPage()
        }
    }

    @Preview
    @Composable
    fun MainPage() {
        Button(
            content = { Text("退出登录") },
            onClick = {
                val logout = mainViewModel.logout()
                if (logout) {
                    startActivity<LoginActivity>()
                    finish()
                }
            })
    }
}


