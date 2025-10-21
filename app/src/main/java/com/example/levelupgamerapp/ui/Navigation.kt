package com.example.levelupgamerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.levelupgamerapp.ui.screens.*

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "splash" // Pantalla inicial
    ) {
        composable(route = "splash") {
            SplashScreen(navController)
        }
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "register") {
            RegisterScreen(navController)
        }
        composable(route = "welcome") {
            WelcomeScreen(navController)
        }
        composable(route = "main") {
            MainScreen(navController)
        }
        composable(route = "producto") {
            ProductoScreen(navController)
        }
        composable(route = "carrito") {
            CarritoScreen(navController, carrito = emptyList())
        }
    }
}
