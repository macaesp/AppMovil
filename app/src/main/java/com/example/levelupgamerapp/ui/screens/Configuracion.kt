package com.example.levelupgamerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfiguracionScreen(
    onCerrarSesion: () -> Unit,
    onCambiarTema: (Boolean) -> Unit
) {
    var notificacionesHabilitadas by remember { mutableStateOf(true) }
    var temaOscuro by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Text(
            text = "Configuración",
            color = Color(0xFF76FF03),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // 🔔 Notificaciones
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Notificaciones",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = notificacionesHabilitadas,
                onCheckedChange = { notificacionesHabilitadas = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF76FF03),
                    uncheckedThumbColor = Color.Gray
                )
            )
        }

        // 🌙 Tema oscuro
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tema oscuro",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = temaOscuro,
                onCheckedChange = {
                    temaOscuro = it
                    onCambiarTema(it)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF76FF03),
                    uncheckedThumbColor = Color.Gray
                )
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 🔒 Botón cerrar sesión
        Button(
            onClick = onCerrarSesion,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Cerrar sesión",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
