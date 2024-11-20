package com.erdemyesilcicek.flokii.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = pink,
    secondary = purple,
    tertiary = darkPurple,
    background = offWhite,
    onPrimary = offWhite,
    onBackground = lightPurple
)

private val LightColorScheme = lightColorScheme(
    primary = pink,
    secondary = purple,
    tertiary = darkPurple,
    background = Color.White,
    onPrimary = offWhite,
    onBackground = lightPurple,
    surface = gray
)

@Composable
fun FlokiiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}