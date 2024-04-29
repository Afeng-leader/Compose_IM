package com.af.abner_af_im.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.af.abner_af_im.view.ComponentImage
import com.af.abner_af_im.R
import com.af.abner_af_im.provider.ContextProvider
import com.af.abner_af_im.provider.LastLoginAccountProvider
import com.af.abner_af_im.provider.ToastProvider
import com.af.abner_af_im.view.CircleBox
import com.af.abner_af_im.view.clickableNoRipple


//@Composable
//fun LoginPage2(onLoginButtonClick: (String) -> Unit) {
//    Scaffold(
//        modifier = Modifier.fillMaxSize()
//    ) { paddingValues ->
//        Box(
//            modifier = Modifier
//                .padding(paddingValues = paddingValues)
//                .fillMaxSize()
//
//        ) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//
//                Text(
//                    text = stringResource(id = R.string.app_name),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight(fraction = 0.19f)
//                        .wrapContentSize(align = Alignment.BottomCenter),
//                    fontSize = 60.sp,
//                    fontFamily = FontFamily.Cursive,
//                    textAlign = TextAlign.Center
//                )
//
//                ComponentImage(
//                    modifier = Modifier
//                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
//                        .size(size = 90.dp)
//                        .clip(shape = CircleShape),
//                    model = R.mipmap.ic_launcher
//                )
//                Text(
//                    text = "user name: " + LastLoginAccountProvider.lastLoginUserId,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 10.dp),
//                    fontSize = 30.sp,
//                    textAlign = TextAlign.Center
//                )
//
//                Text(
//                    text = ContextProvider.context.getString(R.string.account_manager),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 10.dp)
//                        .clickableNoRipple {
//                            ToastProvider.showToast(resId = R.string.account_manager)
//                        },
//                    fontSize = 15.sp,
//                    textAlign = TextAlign.Center,
//                    color = Color(0xFF4F82BA),
//                )
//
//                Button(modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 40.dp, end = 40.dp, top = 60.dp),
//                    shape = RoundedCornerShape(7.dp),
//                    content = {
//                        Text(
//                            modifier = Modifier.padding(vertical = 2.dp),
//                            text = ContextProvider.context.getString(R.string.one_click_login),
//                            fontSize = 16.sp,
//                            color = Color.White
//                        )
//                    },
//                    onClick = {
//                        onLoginButtonClick(LastLoginAccountProvider.lastLoginUserId)
//                    })
//
//
//
//                Text(
//                    text = ContextProvider.context.getString(R.string.add_account),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 60.dp)
//                        .clickableNoRipple {
//                            ToastProvider.showToast(resId = R.string.account_manager)
//                        },
//                    fontSize = 15.sp,
//                    textAlign = TextAlign.Center,
//                    color = Color(0xFF4F82BA),
//                )
//            }
//        }
//
//    }
//
//}










