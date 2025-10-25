package com.example.levelupgamerapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.viewmodel.ProductoViewModel

class DetalleProductoActivity : ComponentActivity() {

    private val productoViewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recibir el producto desde el Intent
        val productoJson = intent.getStringExtra("producto")
        val producto = productoJson?.let {
            com.google.gson.Gson().fromJson(it, Producto::class.java)
        }

        setContent {
            if (producto != null) {
                DetalleProductoScreen(
                    producto = producto,
                    onAgregarCarrito = { productoViewModel.agregarProducto(producto) }
                )
            } else {
                Text(
                    text = "No se encontró el producto.",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun DetalleProductoScreen(
    producto: Producto,
    onAgregarCarrito: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del producto
        val resId = producto.imagenResId ?: R.drawable.ic_gamepad
        Image(
            painter = painterResource(id = resId),
            contentDescription = producto.nombre,
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Información del producto
        Text(
            text = producto.nombre,
            color = Color(0xFF76FF03),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = producto.descripcion,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Precio: $${producto.precio}",
            color = Color(0xFF76FF03),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón agregar al carrito
        Button(
            onClick = onAgregarCarrito,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = "Agregar al carrito", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}
