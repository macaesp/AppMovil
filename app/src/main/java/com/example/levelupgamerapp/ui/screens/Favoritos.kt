package com.example.levelupgamerapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levelupgamerapp.model.Producto
import com.example.levelupgamerapp.R

@Composable
fun FavoritosScreen(
    favoritos: List<Producto>,
    onQuitarFavorito: (Producto) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Text(
            text = "Tus Favoritos",
            color = Color(0xFF76FF03),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (favoritos.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No tienes productos favoritos aún.",
                    color = Color.Gray,
                    fontSize = 18.sp
                )
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(favoritos) { producto ->
                    FavoritoItem(producto = producto, onQuitarFavorito = onQuitarFavorito)
                }
            }
        }
    }
}

@Composable
fun FavoritoItem(producto: Producto, onQuitarFavorito: (Producto) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(
                    id = producto.imagenResId ?: R.drawable.ic_gamepad
                ),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 12.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = producto.nombre,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$${producto.precio}",
                    color = Color(0xFF76FF03),
                    fontSize = 16.sp
                )
            }

            Button(
                onClick = { onQuitarFavorito(producto) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03))
            ) {
                Text(text = "Quitar", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
