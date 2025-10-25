package com.example.levelupgamerapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = NeonGreen,
    secondary = LightGrayText,
    background = DarkBackground,
    surface = DarkBackground,
    onPrimary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = NeonGreen,
    secondary = LightGrayText,
    background = LightBackground,
    surface = LightBackground,
    onPrimary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun LevelUpGamerAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
