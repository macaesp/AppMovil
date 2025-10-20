package com.example.levelupgamerapp.model

data class CarroCompras(
    val items: MutableMap<Producto, Int> = mutableMapOf()
) {
    fun agregarProducto(producto: Producto, cantidad: Int = 1) {
        val cantidadActual = items[producto] ?: 0
        items[producto] = cantidadActual + cantidad
    }

    fun removerProducto(producto: Producto, cantidad: Int = 1) {
        val cantidadActual = items[producto] ?: 0
        val nuevaCantidad = cantidadActual - cantidad
        if (nuevaCantidad > 0) {
            items[producto] = nuevaCantidad
        } else {
            items.remove(producto)
        }
    }
}