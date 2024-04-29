package com.af.abner_af_im.ui.login

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
//import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.af.abner_af_im.R
import com.af.abner_af_im.provider.LastLoginAccountProvider
import com.af.abner_af_im.provider.ToastProvider
import com.af.abner_af_im.state.LoginPageViewState


//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun LoginPage(viewState: LoginPageViewState, onLoginButtonClick: (String) -> Unit) {
//    Scaffold(
//        modifier = Modifier.fillMaxSize()
//    ) { paddingValues ->
//        Box(
//            modifier = Modifier
//                .padding(paddingValues = paddingValues)
//                .fillMaxSize()
//                .background(
//                    Brush.verticalGradient(
//                        listOf(
//                            Color.Cyan,
//                            Color.White,
//
//                            )
//                    )
//                )
//
//        ) {
//            val localSoftwareKeyboardController = LocalSoftwareKeyboardController.current
//            BackHandler(enabled = viewState.isLoading.value) {}
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                if (viewState.isShowLoginPage.value) {
//
//                    if (LastLoginAccountProvider.accountLogin) {
//                        LoginPage2(
//                            onLoginButtonClick = { onLoginButtonClick(it) }
//                        )
//                    }
//
//                    Text(
//                        text = stringResource(id = R.string.app_name),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight(fraction = 0.19f)
//                            .wrapContentSize(align = Alignment.BottomCenter),
//                        fontSize = 60.sp,
//                        fontFamily = FontFamily.Cursive,
//                        textAlign = TextAlign.Center
//                    )
//                    var userId by remember {
//                        val lastLoginUserId by viewState.lastLoginUserId
//                        mutableStateOf(
//                            value = TextFieldValue(
//                                text = lastLoginUserId,
//                                selection = TextRange(index = lastLoginUserId.length)
//                            )
//                        )
//                    }
//                    OutlinedTextField(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 80.dp, start = 40.dp, end = 40.dp),
//                        maxLines = 1,
//                        label = {
//                            Text(text = "UserId", fontSize = 14.sp)
//                        },
//                        value = userId,
//                        onValueChange = { textField ->
//                            val trimText = textField.text.trimStart().trimEnd()
//                            if (trimText.length <= 12 && trimText.all {
//                                    it.isLowerCase() || it.isUpperCase()
//                                }) {
//                                userId = textField
//                            }
//                        },
//                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
//                        keyboardActions = KeyboardActions(onGo = {
//                            onLoginButtonClick(userId.text)
//                        })
//                    )
//
//                    Button(modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 30.dp, end = 30.dp, top = 40.dp),
//                        content = {
//                            Text(
//                                modifier = Modifier.padding(vertical = 2.dp),
//                                text = "Login",
//                                fontSize = 16.sp,
//                                color = Color.White
//                            )
//                        },
//                        onClick = {
//                            val text = userId.text.trim()
//                            if (text.isBlank()) {
//                                ToastProvider.showToast(resId = R.string.please_enter_userid)
//                            } else {
//                                localSoftwareKeyboardController?.hide()
//                                onLoginButtonClick(text)
//                            }
//                        })
//                }
//            }
//            LoadingDialog(visible = viewState.isLoading.value)
//        }
//
//    }
//
//}
//
//@Composable
//fun LoadingDialog(visible: Boolean) {
//    if (visible) {
//        BackHandler(enabled = true) {
//        }
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            CircularProgressIndicator(
//                modifier = Modifier
//                    .align(alignment = Alignment.Center)
//                    .size(size = 36.dp),
//                color = MaterialTheme.colorScheme.primary,
//                strokeWidth = 3.dp
//            )
//        }
//    }
//}

