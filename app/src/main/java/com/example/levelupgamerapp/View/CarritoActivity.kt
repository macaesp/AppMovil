package com.example.levelupgamerapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.levelupgamerapp.ui.screens.CarritoScreen
import com.example.levelupgamerapp.viewmodel.ProductoViewModel

class CarritoActivity : ComponentActivity() {

    private val productoViewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val carrito = productoViewModel.carrito.value

            CarritoScreen(
                carrito = carrito,
                onAumentar = { producto ->
                    productoViewModel.agregarProducto(producto)
                },
                onDisminuir = { producto ->
                    productoViewModel.disminuirProducto(producto)
                },
                onFinalizarCompra = {
                    productoViewModel.vaciarCarrito()
                }
            )
        }
    }
}
