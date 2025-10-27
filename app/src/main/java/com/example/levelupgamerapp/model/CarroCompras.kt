package com.example.levelupgamerapp.model

data class CarroCompras(
    val items: MutableMap<Producto, Int> = mutableMapOf()
) {
    fun agregar(producto: Producto) {
        items[producto] = (items[producto] ?: 0) + 1
    }

    fun eliminar(producto: Producto) {
        items.remove(producto)
    }

    fun disminuir(producto: Producto) {
        val current = items[producto] ?: return
        if (current > 1) {
            items[producto] = current - 1
        } else {
            items.remove(producto)
        }
    }

    fun vaciar() {
        items.clear()
    }

    fun copy(): CarroCompras {
        // Esto crea una copia nueva para que Compose detecte el cambio
        return CarroCompras(items.toMutableMap())
    }
}
