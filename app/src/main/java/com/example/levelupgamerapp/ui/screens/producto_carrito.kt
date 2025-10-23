package com.example.levelupgamerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.levelupgamerapp.model.Producto

@Composable
fun ProductoCarritoScreen(
    navController: NavController,
    productos: List<Producto> = emptyList(),
    onEliminar: (Producto) -> Unit = {},
    onVaciarCarrito: () -> Unit = {},
    onFinalizarCompra: () -> Unit = {}
) {
    val total = productos.sumOf { it.precio }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "🛍️ Productos en tu Carrito",
            color = Color(0xFF76FF03),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de productos
        if (productos.isEmpty()) {
            Text(
                text = "Tu carrito está vacío.",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 40.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(productos) { producto ->
                    ProductoCarritoItem(producto = producto, onEliminar = onEliminar)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Total
            Text(
                text = "Total: $${"%.2f".format(total)}",
                color = Color(0xFF76FF03),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Botones de acción
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = onVaciarCarrito,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Vaciar", color = Color.White)
                }

                Button(
                    onClick = onFinalizarCompra,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03))
                ) {
                    Text("Finalizar", color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate("main") }) {
            Text("⬅ Volver a la tienda", color = Color(0xFF76FF03))
        }
    }
}

@Composable
fun ProductoCarritoItem(
    producto: Producto,
    onEliminar: (Producto) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = producto.nombre,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "$${producto.precio}",
                    color = Color(0xFF76FF03),
                    fontSize = 16.sp
                )
            }

            Button(
                onClick = { onEliminar(producto) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Eliminar", color = Color.White)
            }
        }
    }
}
