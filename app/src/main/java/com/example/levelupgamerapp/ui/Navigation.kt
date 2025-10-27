// ui/navigation/AppNavigation.kt
package com.example.levelupgamerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.levelupgamerapp.ui.screens.*
import com.example.levelupgamerapp.viewmodel.ProductoViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val productoViewModel: ProductoViewModel = viewModel() // tu ViewModel

    NavHost(navController = navController, startDestination = "welcome") {

        composable("welcome") {
            WelcomeScreen(navController)
        }

        composable("login") {
            LoginScreen(navController) { email, password ->
                // Aquí iría la lógica real de login
                navController.navigate("main") {
                    popUpTo("welcome") { inclusive = true }
                }
            }
        }

        composable("register") {
            RegisterScreen(navController) { nombre, email, password ->
                // Lógica de registro
                navController.navigate("main") {
                    popUpTo("welcome") { inclusive = true }
                }
            }
        }

        composable("main") {
            MainScreen(
                navController = navController,
                productos = productoViewModel.productos,
                onAgregarAlCarrito = { productoViewModel.agregarProducto(it) },
                onVerDetalle = { producto ->
                    navController.navigate("producto/${producto.id}")
                }
            )
        }

        composable("carrito") {
            ProductoCarritoScreen(
                navController = navController,
                productos = productoViewModel.carrito.value.items.keys.toList(),
                onEliminar = { productoViewModel.eliminarProducto(it) },
                onVaciarCarrito = { productoViewModel.vaciarCarrito() },
                onFinalizarCompra = {
                    productoViewModel.vaciarCarrito()
                    // Aquí puedes mostrar mensaje de éxito
                }
            )
        }

        composable("producto/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val producto = productoViewModel.productos.find { it.id == id }
            if (producto != null) {
                ProductoScreen(
                    navController = navController,
                    producto = producto,
                    onAgregarAlCarrito = { productoViewModel.agregarProducto(it) }
                )
            }
        }
    }
}
