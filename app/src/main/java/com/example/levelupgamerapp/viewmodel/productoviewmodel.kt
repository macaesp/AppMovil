package com.example.levelupgamerapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.levelupgamerapp.model.CarroCompras
import com.example.levelupgamerapp.model.Producto

class ProductoViewModel : ViewModel() {

    // Lista de productos disponibles (puedes modificarla)
    val productos = listOf(
        Producto(
            1, "Control Inalámbrico", 49990, "ic_gamepad",
            descripcion = TODO(),
            imagenResId = TODO()
        ),
        Producto(
            2, "Teclado Mecánico RGB", 89990, "ic_keyboard",
            descripcion = TODO(),
            imagenResId = TODO()
        ),
        Producto(
            3, "Mouse Gamer", 29990, "ic_mouse",
            descripcion = TODO(),
            imagenResId = TODO()
        )
    )

    // Estado del carrito
    private val _carrito = mutableStateOf(CarroCompras())
    val carrito get() = _carrito

    // Agregar producto al carrito
    fun agregarProducto(producto: Producto) {
        _carrito.value.agregarProducto(producto)
    }

    // Disminuir cantidad de producto
    fun removerProducto(producto: Producto) {
        _carrito.value.removerProducto(producto)
    }

    // Vaciar el carrito
    fun limpiarCarrito() {
        _carrito.value = CarroCompras()
    }
}
