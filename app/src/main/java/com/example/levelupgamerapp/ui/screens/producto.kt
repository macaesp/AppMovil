package com.example.levelupgamerapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto

@Composable
fun ProductoScreen(
    navController: NavController,
    producto: Producto,
    onAgregarAlCarrito: (Producto) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del producto
        Image(
            painter = painterResource(id = R.drawable.ic_gamepad), // temporal
            contentDescription = producto.nombre,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre del producto
        Text(
            text = producto.nombre,
            color = Color(0xFF76FF03),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Descripción
        Text(
            text = producto.descripcion ?: "Sin descripción disponible.",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Precio
        Text(
            text = "Precio: $${producto.precio}",
            color = Color(0xFF76FF03),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón Agregar al carrito
        Button(
            onClick = { onAgregarAlCarrito(producto) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text("Agregar al carrito", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón Volver
        TextButton(onClick = { navController.popBackStack() }) {
            Text("⬅ Volver a la tienda", color = Color(0xFF76FF03))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductoScreenPreview() {
    val navController = rememberNavController()
    val producto = Producto(1, "Teclado Mecánico RGB", 120, "Teclados", "Teclado para gaming con switches rojos", R.drawable.ic_gamepad)
    ProductoScreen(navController = navController, producto = producto, onAgregarAlCarrito = {})
}
