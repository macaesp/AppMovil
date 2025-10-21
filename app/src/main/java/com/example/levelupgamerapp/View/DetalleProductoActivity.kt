package com.example.levelupgamerapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto
import com.google.gson.Gson

class DetalleProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        // Referencias UI
        val imgProducto = findViewById<ImageView>(R.id.imgDetalle)
        val txtNombre = findViewById<TextView>(R.id.txtNombreDetalle)
        val txtDescripcion = findViewById<TextView>(R.id.txtDescripcionDetalle)
        val txtPrecio = findViewById<TextView>(R.id.txtPrecioDetalle)
        val btnAgregar = findViewById<Button>(R.id.btnAgregarCarrito)

        // Recibir producto desde el intent
        val productoJson = intent.getStringExtra("producto")
        val producto = Gson().fromJson(productoJson, Producto::class.java)

        // Mostrar datos
        txtNombre.text = producto.nombre
        txtDescripcion.text = producto.descripcion
        txtPrecio.text = "$${producto.precio}"

        // Imagen
        val resId = resources.getIdentifier(
            producto.imagenUrl ?: "ic_gamepad",
            "drawable",
            packageName
        )
        imgProducto.setImageResource(resId)

        btnAgregar.setOnClickListener {
            // Aquí puedes implementar la lógica para agregar al carrito
            // (por ejemplo usando un ViewModel o SharedPreferences)
            finish()
        }
    }
}
