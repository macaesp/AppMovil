package com.example.levelupgamerapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.levelupgamerapp.R
import com.example.levelupgamerapp.View.LoginActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nombre = findViewById<EditText>(R.id.inputNombre)
        val correo = findViewById<EditText>(R.id.inputCorreo)
        val contrasena = findViewById<EditText>(R.id.inputContrasena)
        val confirmar = findViewById<EditText>(R.id.inputConfirmar)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val txtIrLogin = findViewById<TextView>(R.id.txtIrLogin)

        btnRegistrar.setOnClickListener {
            val nombreTxt = nombre.text.toString().trim()
            val correoTxt = correo.text.toString().trim()
            val passTxt = contrasena.text.toString().trim()
            val confirmTxt = confirmar.text.toString().trim()

            when {
                nombreTxt.isEmpty() || correoTxt.isEmpty() || passTxt.isEmpty() || confirmTxt.isEmpty() -> {
                    Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                }
                passTxt != confirmTxt -> {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Cuenta creada exitosamente 🎉", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        txtIrLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
