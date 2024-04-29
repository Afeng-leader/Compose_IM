package com.af.abner_af_im.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import com.af.abner_af_im.common.AppTheme
import com.af.abner_af_im.provider.AppThemeProvider


private val primaryColorLight = Color(0xFF42A5F5)
private val inverseSurfaceColorLight = Color(0xFFE2E1EC)
private val inverseOnSurfaceColorLight = Color(0xFF3A3D4D)
private val onPrimaryColorLight = Color(0xFF22202A)
private val primaryContainerColorLight = Color(0xFFFFFFFF)
private val surfaceColorLight = Color(0xFFFFFFFF)
private val onSurfaceColorLight = Color(0xFF1C1B1F)
private val backgroundColorLight = Color(0xFFFFFFFF)
private val onSecondaryContainerLight = Color(0xFFF4F4F4)

private val primaryColorDark = Color(0xFF26A69A)
private val inverseSurfaceColorDark = Color(0xFF45464F)
private val inverseOnSurfaceColorDark = Color(0xFFFFFFFF)
private val onPrimaryColorDark = Color(0xFFFFFFFF)
private val primaryContainerColorDark = Color(0xFF3A3D4D)
private val surfaceColorDark = Color(0xFF22202A)
private val onSurfaceColorDark = Color(0xFFFFFFFF)
val backgroundColorDark = Color(0xFF22202A)
private val onSecondaryContainerDark = Color(0xFF3A3D4D)

private val LightColorScheme = lightColorScheme(
    primary = primaryColorLight,
    onPrimary = onPrimaryColorLight,
    primaryContainer = primaryContainerColorLight,
    surface = surfaceColorLight,
    onSurface = onSurfaceColorLight,
    inverseSurface = inverseSurfaceColorLight,
    inverseOnSurface = inverseOnSurfaceColorLight,
    background = backgroundColorLight,
    onSecondaryContainer = onSecondaryContainerLight
)

private val DarkColorScheme = darkColorScheme(
    primary = primaryColorDark,
    onPrimary = onPrimaryColorDark,
    primaryContainer = primaryContainerColorDark,
    surface = surfaceColorDark,
    onSurface = onSurfaceColorDark,
    inverseSurface = inverseSurfaceColorDark,
    inverseOnSurface = inverseOnSurfaceColorDark,
    background = backgroundColorDark,
    onSecondaryContainer = onSecondaryContainerDark
)



@Composable
fun Abner_Af_IMTheme(content: @Composable () -> Unit) {
    val colorScheme = when (AppThemeProvider.appTheme) {
        AppTheme.Light, AppTheme.Gray -> {
            LightColorScheme
        }

        AppTheme.Dark -> {
            DarkColorScheme
        }
    }
    val context = LocalContext.current
    val rememberedDensity = remember {
        Density(
            density = context.resources.displayMetrics.widthPixels / 380f,
            fontScale = 1f
        )
    }
    CompositionLocalProvider(LocalDensity provides rememberedDensity) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = {
                content()
                if (AppThemeProvider.appTheme == AppTheme.Gray) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawRect(
                            color = Color.LightGray,
                            blendMode = BlendMode.Saturation
                        )
                    }
                }
            }
        )
    }
}