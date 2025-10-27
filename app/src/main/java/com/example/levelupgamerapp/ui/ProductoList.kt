package com.example.levelupgamerapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto

@Composable
fun ProductoList(
    productos: List<Producto>,
    onAgregarClick: (Producto) -> Unit,
    onVerDetalleClick: (Producto) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(8.dp)
    ) {
        items(productos) { producto ->
            ProductoItem(
                producto = producto,
                onAgregarClick = { onAgregarClick(producto) },
                onVerDetalleClick = { onVerDetalleClick(producto) }
            )
        }
    }
}

@Composable
private fun ProductoItem(
    producto: Producto,
    onAgregarClick: () -> Unit,
    onVerDetalleClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onVerDetalleClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = producto.imagenResId ?: R.drawable.ic_gamepad),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 12.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    producto.nombre,
                    color = Color(0xFF76FF03),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    producto.descripcion,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    "$${producto.precio}",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Button(
                onClick = onAgregarClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03))
            ) {
                Text("Agregar", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
