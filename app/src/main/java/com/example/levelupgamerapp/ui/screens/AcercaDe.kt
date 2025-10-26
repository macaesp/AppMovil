package com.example.levelupgamerapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levelupgamerapp.R

@Composable
fun AcercaDeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 🕹️ Logo de la app
        Image(
            painter = painterResource(id = R.drawable.ic_gamepad),
            contentDescription = "Logo LevelUpGamer",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )

        // 🟢 Título
        Text(
            text = "LevelUpGamer",
            color = Color(0xFF76FF03),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // ℹ️ Descripción general
        Text(
            text = "Aplicación desarrollada para ofrecer la mejor experiencia de compra gamer. Encuentra accesorios, periféricos y tecnología con estilo.",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Divider(
            color = Color(0xFF76FF03),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // 🧑‍💻 Información del desarrollador
        Text(
            text = "Desarrollado por:",
            color = Color(0xFF76FF03),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = "Benjamín González\nDuoc UC - Sede Valparaíso Centro",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ⚙️ Versión del sistema
        Text(
            text = "Versión 1.0.0",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 📩 Contacto
        Button(
            onClick = { /* Podrías agregar un intent a correo o web */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03))
        ) {
            Text(
                text = "Contactar soporte",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AcercaDeScreenPreview() {
    AcercaDeScreen()
}
