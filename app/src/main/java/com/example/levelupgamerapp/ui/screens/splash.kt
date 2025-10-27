package com.example.levelupgamerapp.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.levelupgamerapp.R
import kotlinx.coroutines.delay

// Definición de colores clave del tema Gamer
val GamerBlack = Color(0xFF000000)
val GamerNeonGreen = Color(0xFF39FF14)
val GamerElectricBlue = Color(0xFF1E90FF)

@Composable
fun SplashScreen(navController: NavController) {
    // Controla la animación de fade in
    val alphaAnim = remember { Animatable(0f) }

    // Controla el pulso del texto "Cargando..."
    val pulseAnim = rememberInfiniteTransition(label = "pulse")
    val pulseAlpha by pulseAnim.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "pulse_alpha"
    )

    // Lanzar animación y cambio de pantalla
    LaunchedEffect(Unit) {
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1500)
        )
        delay(2500) // Mostrar por 2.5 segundos
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Diseño visual del Splash
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GamerBlack),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Logo animado
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "Logo LevelUpGamer",
                modifier = Modifier
                    .size(180.dp)
                    .graphicsLayer(alpha = alphaAnim.value)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Título: LevelUpGamer (Verde Neón)
            Text(
                text = "LEVEL-UP GAMER",
                color = GamerNeonGreen,
                fontSize = 36.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.graphicsLayer(alpha = alphaAnim.value)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Iniciando Sistema...",
                color = GamerElectricBlue,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .graphicsLayer(alpha = pulseAlpha)
                    .padding(horizontal = 48.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}