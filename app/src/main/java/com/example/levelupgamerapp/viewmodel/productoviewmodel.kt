package com.example.levelupgamerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.levelupgamerapp.data.repository.ProductoRepository
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.model.CarroCompras

class ProductoViewModel(private val repository: ProductoRepository) : ViewModel() {
    val productos: List<Producto> = repository.getAllproductos()
    private val _carroCompras = MutableLiveData<CarroCompras>(CarroCompras())
    val carroCompras: LiveData<CarroCompras>
        get() = _carroCompras

    fun agregarAlCarro(producto: Producto, cantidad:Int = 1) {
        val carroActual = _carroCompras.value ?: CarroCompras()
        carroActual.agregarProducto(producto, cantidad)
        _carroCompras.value = carroActual
    }

    fun removerDelCarro(producto: Producto, cantidad:Int = 1) {
        val carroActual = _carroCompras.value ?: CarroCompras()
        carroActual.removerProducto(producto, cantidad)
        _carroCompras.value = carroActual
    }

    fun limpiarCarro() {
        _carroCompras.value = CarroCompras()
    }

}
