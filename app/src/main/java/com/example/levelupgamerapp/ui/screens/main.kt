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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.model.Producto
@Composable
fun MainScreen(
    navController: NavController,            // <- agregado
    productos: List<Producto>,
    onAgregarAlCarrito: (Producto) -> Unit,
    onVerDetalle: (Producto) -> Unit
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
                text = producto.descripcion,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "$${"%.2f".format(producto.precio)}",
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    val productos = listOf(
        Producto(1, "Catan", 29990, "Juegos de Mesa", "Juego clasico de estrategia en donde los jugadores compiten para colonizar y expandirse en la isa de catan, Ideal para 3-4 jugadores",
            R.drawable.catan),
        Producto(2, "Carcassonne", 24990, "Juegos de Mesa","Juego de colocaciobn de fichas en donde los jugadores construyen el paisaje de la fortaleza medieval, Ideal para 2-5 jugadores",R.drawable.carcassonne),
        Producto(3, "Controlador Inalámbrico Xbox Series X ", 59990,"Accesorios", "Ofrece una experencia de juego comoda con botones mapeables y una respuesta tactil mejorada.",R.drawable.mandoxbox),
        Producto(4, "Auriculares Gamer HyperX Cloud II", 79990,"Acccesorios","Proporcionan un sonido envolvente de calidad con un microfono desmontable y almohadillas de espuma para mayor comodidad.",R.drawable.auriculares),
        Producto(6,"PlayStation 5",549990,"Consolas","Consola de ultima generacion de Sony,ofrece graficos impresionantes y tiempos de carga ultrapidos.",R.drawable.playstation),
        Producto(7,"PC Gamer ASUS ROG Strix",1299990,"Computadores Gamer","Potente equipo diseñado para ofrecer un rendimiento exceptcional en cualquier juego.",R.drawable.playstation),
        Producto(8,"Silla Gamer Secretlab Titan",349990,"Sillas Gamers","Diseñada para el maximo comfort,ofrece un soporte ergonomico y personalizacion ajustable.",R.drawable.silla),
        Producto(9,"Mouse Gamer Logitech G502 HERO",49990,"Mouse","Con sensor de alta presicion y botones personalizables,este mouse es ideal para gamers que buscan un control preciso.",R.drawable.mouse),
        Producto(10,"Mousepad Razer Goliathus Extended Chroma",29990,"Mousepad","Ofere una area amplia con iluminacion RGB personalizable.",R.drawable.mousepad),
        Producto(10,"Polera Gamer Personalizada 'Level-Up'",14990,"Poleras Personalizadas","Una polera comoda y estilizada, con la frase 'Level-Up' en el interior.",R.drawable.leveluppolera)
    )
    MainScreen(
        navController = navController,
        productos = productos,
        onAgregarAlCarrito = {},
        onVerDetalle = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ProductoItemPreview() {
    ProductoItem(
        producto = Producto(1, "Catan", 29990, "Juego de Mesa","Juego clasico de estrategia en donde los jugadores compiten para colonizar y expandirse en la isa de catan, Ideal para 3-4 jugadores",R.drawable.catan),
        onAgregarAlCarrito = {}
    )
}
