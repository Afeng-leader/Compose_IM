package com.af.abner_af_im.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircleBox(content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier
            //1.裁剪
            .clip(CircleShape)
            //2.设置背景色，通过brush实现渐变色，Blue1,Blue2是自定义的颜色类型是Color
            .background(
//                brush = Brush.horizontalGradient(
//                    listOf(
//                        Color(0xFF4F82BA),
//                        Color(0xFF4F82BA)
//                    )
//                )
                color = Color.Black
            )
            //3.padding撑开
            .padding(20.dp),
        content = content,
    )
}