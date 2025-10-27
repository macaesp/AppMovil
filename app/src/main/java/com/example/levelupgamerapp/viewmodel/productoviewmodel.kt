package com.example.levelupgamerapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.levelupgamerapp.data.repository.ProductoRepository
import com.example.levelupgamerapp.model.CarroCompras
import com.example.levelupgamerapp.model.Producto

class ProductoViewModel(private val repository: ProductoRepository) : ViewModel() {

    val productos = repository.getProductos()  // Obtenemos los productos desde repo
    val carrito = mutableStateOf(CarroCompras())

    fun agregarProducto(producto: Producto) {
        carrito.value.agregar(producto)
        carrito.value = carrito.value.copy()
    }

    fun eliminarProducto(producto: Producto) {
        carrito.value.eliminar(producto)
        carrito.value = carrito.value.copy()
    }

    fun disminuirProducto(producto: Producto) {
        carrito.value.disminuir(producto)
        carrito.value = carrito.value.copy()
    }

    fun vaciarCarrito() {
        carrito.value.vaciar()
        carrito.value = carrito.value.copy()
    }

    fun getProductoById(id: Int): Producto? {
        return repository.getProductoById(id)
    }
}
