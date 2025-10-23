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
import com.example.levelupgamerapp.model.Usuario

@Composable
fun PerfilUsuarioScreen(
    usuario: Usuario?,
    onEditarPerfil: (String, String) -> Unit,
    onCerrarSesion: () -> Unit
) {
    var nombre by remember { mutableStateOf(usuario?.usuario ?: "") }
    var correo by remember { mutableStateOf(usuario?.gmail ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil del Usuario",
            color = Color(0xFF76FF03),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo") },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF76FF03),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFF76FF03),
                focusedLabelColor = Color(0xFF76FF03),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            singleLine = true,
            enabled = false, // El correo no se puede modificar
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF76FF03),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFF76FF03),
                focusedLabelColor = Color(0xFF76FF03),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                disabledTextColor = Color.LightGray
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onEditarPerfil(nombre, correo) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Cambios", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onCerrarSesion,
            border = ButtonDefaults.outlinedButtonBorder,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cerrar Sesión", color = Color(0xFF76FF03))
        }
    }
}
