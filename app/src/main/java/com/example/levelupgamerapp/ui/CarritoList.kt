
package com.example.levelupgamerapp.ui.components

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
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.CarroCompras
import com.example.levelupgamerapp.model.Producto

@Composable
fun CarritoList(
    carro: CarroCompras,
    onAumentar: (Producto) -> Unit,
    onDisminuir: (Producto) -> Unit
) {
    val items = carro.items.entries.toList() // List<Map.Entry<Producto, Int>>

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(8.dp)
    ) {
        items(items) { (producto, cantidad) ->
            CarritoItem(
                producto = producto,
                cantidad = cantidad,
                onAumentar = { onAumentar(producto) },
                onDisminuir = { onDisminuir(producto) }
            )
        }
    }
}

@Composable
private fun CarritoItem(
    producto: Producto,
    cantidad: Int,
    onAumentar: () -> Unit,
    onDisminuir: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = producto.imagenResId ?: R.drawable.ic_gamepad),
                contentDescription = "Producto",
                modifier = Modifier.size(64.dp).padding(end = 12.dp)
            )
            Column(Modifier.weight(1f)) {
                Text(producto.nombre, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("x$cantidad", color = Color(0xFF76FF03), fontSize = 16.sp)
                Text("$${producto.precio * cantidad}", color = Color.White, fontSize = 14.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                FilledTonalButton(onClick = onAumentar, colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color(0xFF76FF03))) {
                    Text("+", color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(8.dp))
                OutlinedButton(onClick = onDisminuir, border = ButtonDefaults.outlinedButtonBorder, colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF76FF03))) {
                    Text("–", color = Color(0xFF76FF03), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
