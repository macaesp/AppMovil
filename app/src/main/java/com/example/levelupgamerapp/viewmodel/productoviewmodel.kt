package com.example.levelupgamerapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.levelupgamerapp.data.repository.ProductoRepository
import com.example.levelupgamerapp.model.CarroCompras
import com.example.levelupgamerapp.model.Producto

class ProductoViewModel(private val repository: ProductoRepository) : ViewModel() {

    // Lista de productos disponibles
    val productos = repository.getAllproductos()

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
