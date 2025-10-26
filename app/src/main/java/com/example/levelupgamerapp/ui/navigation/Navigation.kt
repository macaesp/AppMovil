package com.example.levelupgamerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.levelupgamerapp.data.repository.ProductoRepository
import com.example.levelupgamerapp.ui.screens.*
import com.example.levelupgamerapp.viewmodel.ProductoViewModel
import com.example.levelupgamerapp.viewmodel.ProductoViewModelFactory

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    val productoRepository = ProductoRepository()
    val productoViewModel: ProductoViewModel = viewModel(factory = ProductoViewModelFactory(productoRepository))

    NavHost(
        navController = navController,
        startDestination = "splash" // Pantalla inicial
    ) {

        // Splash
        composable(route = "splash") {
            SplashScreen(navController)
        }

        // Login y registro
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "register") {
            RegisterScreen(navController)
        }

        // Bienvenida
        composable(route = "welcome") {
            WelcomeScreen(navController)
        }

        // Pantalla principal
        composable(route = "main") {
            MainScreen(
                productos = productoViewModel.productos,
                onAgregarAlCarrito = { producto -> productoViewModel.agregarProducto(producto) },
                onVerDetalle = { producto -> navController.navigate("producto/${producto.id}") }
            )
        }

        // Producto con argumentos dinámicos
        composable(route = "producto/{id}") { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val productoSeleccionado = productoViewModel.productos.find { it.id == productoId }

            if (productoSeleccionado != null) {
                ProductoScreen(
                    navController = navController,
                    producto = productoSeleccionado,
                    onAgregarAlCarrito = { productoViewModel.agregarProducto(it) }
                )
            }
        }

        // Carrito
        composable(route = "carrito") {
            CarritoScreen(
                carrito = productoViewModel.carrito.value,
                onAumentar = { productoViewModel.agregarProducto(it) },
                onDisminuir = { productoViewModel.removerProducto(it) },
                onFinalizarCompra = {
                    productoViewModel.limpiarCarrito()
                    navController.navigate("checkout")
                }
            )
        }
    }
}
