package com.example.levelupgamerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.levelupgamerapp.model.Producto

@Composable
fun MainScreen(
    navController: NavController,
    productos: List<Producto> = emptyList(),
    onAgregarAlCarrito: (Producto) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado
        Text(
            text = "🎮 LevelUp Gamer Store",
            color = Color(0xFF76FF03),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de productos
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productos) { producto ->
                ProductoItem(producto = producto, onAgregarAlCarrito = onAgregarAlCarrito)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botón para ir al carrito
        Button(
            onClick = { navController.navigate("carrito") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Carrito", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ProductoItem(producto: Producto, onAgregarAlCarrito: (Producto) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = producto.nombre,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = producto.descripcion ?: "Sin descripción",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "$${producto.precio}",
                color = Color(0xFF76FF03),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { onAgregarAlCarrito(producto) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Agregar al carrito", color = Color.Black)
            }
        }
    }
}
