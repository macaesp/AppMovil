package com.example.levelupgamerapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.levelupgamerapp.ui.navigation.AppNavigation
import com.example.levelupgamerapp.ui.theme.LevelUpGamerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LevelUpGamerAppTheme {
                AppNavigation()  // Sistema de navegación Compose
            }
        }
    }
}
