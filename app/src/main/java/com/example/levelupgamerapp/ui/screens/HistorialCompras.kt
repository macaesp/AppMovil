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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.ui.theme.LevelUpGamerAppTheme

@Composable
fun HistorialComprasScreen(
    historial: List<Pair<Producto, String>> // Producto + fecha de compra
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Text(
            text = "Historial de Compras",
            color = Color(0xFF76FF03),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (historial.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No has realizado compras aún.",
                    color = Color.Gray,
                    fontSize = 18.sp
                )
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(historial) { (producto, fecha) ->
                    CompraItem(producto = producto, fecha = fecha)
                }
            }
        }
    }
}

@Composable
fun CompraItem(producto: Producto, fecha: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = producto.nombre,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "Precio: $${producto.precio}",
                color = Color(0xFF76FF03),
                fontSize = 16.sp
            )
            Text(
                text = "Fecha: $fecha",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistorialComprasScreenPreview() {
    LevelUpGamerAppTheme {
        val historial = listOf(
            Pair(Producto(1, "Teclado Mecánico RGB", 120, "Teclados", "Descripción", R.drawable.ic_gamepad), "20/05/2024"),
            Pair(Producto(2, "Mouse Gamer", 50, "Mouses", "Descripción", R.drawable.ic_gamepad), "18/05/2024")
        )
        HistorialComprasScreen(historial = historial)
    }
}
