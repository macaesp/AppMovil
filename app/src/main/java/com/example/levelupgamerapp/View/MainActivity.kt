package com.example.levelupgamerapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.viewmodel.ProductoViewModel
import com.example.levelupgamerapp.view.adapter.ProductoAdapter
import com.levelupgamer.view.CarritoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductoAdapter
    private val productoViewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView setup
        recyclerView = findViewById(R.id.recyclerProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Adapter setup
        adapter = ProductoAdapter(emptyList()) { producto ->
            agregarAlCarrito(producto)
        }
        recyclerView.adapter = adapter

        // Observa lista de productos desde ViewModel
        productoViewModel.productos.let {
            adapter.actualizarLista(it)
        }

        // Botón para ir al carrito
        val btnCarrito = findViewById<ImageButton>(R.id.btnCarrito)
        btnCarrito.setOnClickListener {
            val intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun agregarAlCarrito(producto: Producto) {
        productoViewModel.agregarAlCarro(producto)
        Toast.makeText(this, "${producto.nombre} agregado al carrito 🛒", Toast.LENGTH_SHORT).show()
    }
}
