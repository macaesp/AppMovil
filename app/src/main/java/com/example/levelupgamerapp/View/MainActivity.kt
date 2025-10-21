package com.example.levelupgamerapp.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.view.adapter.ProductoAdapter
import com.example.levelupgamerapp.viewmodel.ProductoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductoAdapter
    private val productoViewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ProductoAdapter(emptyList()) { producto ->
            agregarAlCarrito(producto)
        }
        recyclerView.adapter = adapter

        // Observa lista de productos desde ViewModel
        productoViewModel.productos.let {
            adapter.actualizarLista(it)
        }
    }

    private fun agregarAlCarrito(producto: Producto) {
        println("Producto agregado al carrito: ${producto.nombre}")
    }
}
