package com.example.levelupgamerapp.data.repository

import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.R

class ProductoRepository {
    private val productos = listOf(
        Producto(1, "Catan", 24990, "Juegos de Mesa", "Juego de mesa estratégico", R.drawable.ic_launcher_background),
        Producto(2, "Mouse Gamer", 49990, "Accesorios", "Mouse para gaming con sensor preciso", R.drawable.ic_launcher_background)
    )

    // Devuelve todos los productos
    fun getProductos(): List<Producto> = productos

    // Obtener producto por ID
    fun getProductoById(id: Int): Producto? = productos.find { it.id == id }
}
