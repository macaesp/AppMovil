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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.levelupgamerapp.viewmodel.UsuarioViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    usuarioViewModel: UsuarioViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "🔑 Iniciar Sesión",
            fontSize = 28.sp,
            color = Color(0xFF76FF03),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Campo Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF76FF03),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.White,
                focusedLabelColor = Color(0xFF76FF03)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña", color = Color(0xFF76FF03)) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF76FF03),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFF76FF03),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(24.dp))

        // Botón Login
        Button(
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    val exito = usuarioViewModel.iniciarSesion(email, password)
                    if (exito) {
                        navController.navigate("welcome")
                    } else {
                        errorMessage = "Credenciales incorrectas"
                    }
                } else {
                    errorMessage = "Por favor completa todos los campos"
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76FF03))
        ) {
            Text("Iniciar sesión", color = Color.Black, fontWeight = FontWeight.Bold)
        }



        Spacer(modifier = Modifier.height(16.dp))

        // Mensaje de error
        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para registrarse
        TextButton(onClick = { navController.navigate("register") }) {
            Text(
                "¿No tienes cuenta? Regístrate aquí",
                color = Color(0xFF76FF03)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    val usuarioViewModel = UsuarioViewModel() // Mock ViewModel
    LoginScreen(navController = navController, usuarioViewModel = usuarioViewModel)
}
