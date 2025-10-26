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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.CarroCompras
import com.example.levelupgamerapp.model.Producto

@Composable
fun CarritoScreen(
    carrito: CarroCompras,
    onAumentar: (Producto) -> Unit,
    onDisminuir: (Producto) -> Unit,
    onFinalizarCompra: () -> Unit
) {
    val items = carrito.items.toList() // 🔹 convierte el map en lista de pares (Producto, Int)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Text(
            text = "Tu Carrito",
            color = Color(0xFF76FF03),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onFinalizarCompra,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Finalizar Compra",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CarritoItem(
    producto: Producto,
    cantidad: Int,
    onAumentar: () -> Unit,
    onDisminuir: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = producto.imagenResId ?: R.drawable.ic_gamepad),
                contentDescription = "Imagen del producto",
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
                    text = "x$cantidad",
                    color = Color(0xFF76FF03),
                    fontSize = 16.sp
                )
                Text(
                    text = "$${producto.precio * cantidad}",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onAumentar) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_gamepad),
                        contentDescription = "Aumentar",
                        tint = Color(0xFF76FF03)
                    )
                }
                IconButton(onClick = onDisminuir) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_gamepad),
                        contentDescription = "Disminuir",
                        tint = Color(0xFF76FF03)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarritoScreenPreview() {
    CarritoScreen(carrito = CarroCompras(), onAumentar = {}, onDisminuir = {}, onFinalizarCompra = {})
}
