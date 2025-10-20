package com.example.levelupgamerapp.data.repository

import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.R

class ProductoRepository{
    private val productos = listOf(
        Producto(1,"Catan",24990,"Juegos de Mesa","Juego de mesa estrategico", R.drawable.ic_launcher_background)
    )

    fun getAllproductos(): List<Producto> = productos
    fun getProductoById(id: Int): Producto? = productos.find { it.id == id }
}
