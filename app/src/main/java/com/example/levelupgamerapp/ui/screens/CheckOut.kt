package com.example.levelupgamerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutScreen(
    onConfirmarCompra: () -> Unit,
    onCancelar: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var metodoPago by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Finalizar Compra",
            color = Color(0xFF76FF03),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo nombre
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

        Spacer(modifier = Modifier.height(12.dp))

        // Campo dirección
        OutlinedTextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección de entrega") },
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

        Spacer(modifier = Modifier.height(12.dp))

        // Campo método de pago
        OutlinedTextField(
            value = metodoPago,
            onValueChange = { metodoPago = it },
            label = { Text("Método de pago (Ej: Tarjeta, Transferencia, etc.)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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

        Spacer(modifier = Modifier.height(24.dp))

        // Botón Confirmar compra
        Button(
            onClick = onConfirmarCompra,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar Compra", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón Cancelar
        OutlinedButton(
            onClick = onCancelar,
            border = ButtonDefaults.outlinedButtonBorder,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancelar", color = Color(0xFF76FF03))
        }
    }
}
