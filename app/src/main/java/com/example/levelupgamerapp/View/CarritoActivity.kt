package com.example.levelupgamerapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.viewmodel.ProductoViewModel

class CarritoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var txtTotal: TextView
    private lateinit var btnVaciar: Button
    private lateinit var btnComprar: Button
    private lateinit var adapter: CarritoAdapter

    private val productoViewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        recyclerView = findViewById(R.id.recyclerCarrito)
        txtTotal = findViewById(R.id.txtTotal)
        btnVaciar = findViewById(R.id.btnVaciar)
        btnComprar = findViewById(R.id.btnComprar)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CarritoAdapter(emptyList(),
            onAumentar = { producto -> actualizarCantidad(producto, +1) },
            onDisminuir = { producto -> actualizarCantidad(producto, -1) }
        )

        recyclerView.adapter = adapter

        productoViewModel.carroCompras.observe(this) { carro ->
            adapter.actualizarLista(carro.items)
            txtTotal.text = "Total: $${carro.calcularTotal()}"
        }

        btnVaciar.setOnClickListener {
            productoViewModel.limpiarCarro()
            Toast.makeText(this, "Carrito vaciado 🧹", Toast.LENGTH_SHORT).show()
        }

        btnComprar.setOnClickListener {
            Toast.makeText(this, "Compra realizada con éxito", Toast.LENGTH_LONG).show()
            productoViewModel.limpiarCarro()
        }
    }

    private fun actualizarCantidad(producto: Producto, cambio: Int) {
        if (cambio > 0) productoViewModel.agregarAlCarro(producto)
        else productoViewModel.removerDelCarro(producto)
    }
}
