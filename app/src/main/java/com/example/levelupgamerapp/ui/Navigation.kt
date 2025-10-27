// ui/navigation/Navigation.kt
package com.example.levelupgamerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.viewmodel.ProductoViewModel
import com.example.levelupgamerapp.ui.screens.*

@Composable
fun AppNavigation(
    navController: NavHostController,
    productoViewModel: ProductoViewModel
) {
    NavHost(navController = navController, startDestination = "welcome") {

        // Pantalla de bienvenida
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }

        // Pantalla de login
        composable("login") {
            LoginScreen(navController = navController)
        }

        // Pantalla de registro
        composable("register") {
            RegisterScreen(navController = navController)
        }

        // Pantalla principal / lista de productos
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

        // Pantalla de detalle de producto
        composable("producto/{productoId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("productoId")?.toIntOrNull()
            val producto: Producto? = id?.let { productoViewModel.getProductoById(it) }
            if (producto != null) {
                ProductoDetailScreen(
                    producto = producto,
                    navController = navController,
                    onAgregarAlCarrito = { productoViewModel.agregarProducto(it) }
                )
            }
        }

        // Pantalla de carrito
        composable("carrito") {
            CarritoScreen(
                carrito = productoViewModel.carrito.value,
                onAumentar = { productoViewModel.agregarProducto(it) },
                onDisminuir = { productoViewModel.disminuirProducto(it) },
                onFinalizarCompra = {
                    productoViewModel.vaciarCarrito()
                    navController.navigate("checkout")
                }
            )
        }

        composable("checkout") {
            CheckoutScreen(
                onConfirmarCompra = {
                    productoViewModel.vaciarCarrito()
                    navController.navigate("main") //vuelve al inicio
                },
                onCancelar = {
                    navController.popBackStack() // vuelve a la pantalla anterior
                }
            )
        }
    }
}
