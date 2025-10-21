package com.example.levelupgamerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.levelupgamerapp.model.Usuario

class UsuarioViewModel : ViewModel() {

    private val _usuarioActual = MutableLiveData<Usuario?>(null)
    val usuarioActual: LiveData<Usuario?> get() = _usuarioActual

    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> get() = _mensaje

    fun registrarUsuario(nombre: String, correo: String, contrasena: String) {
        if (nombre.isBlank() || correo.isBlank() || contrasena.isBlank()) {
            _mensaje.value = "Todos los campos son obligatorios"
            return
        }
        // Simulación de registro (puedes guardar en SharedPreferences o Room)
        _usuarioActual.value = Usuario(1, nombre, correo, contrasena)
        _mensaje.value = "Usuario registrado exitosamente"
    }

    fun iniciarSesion(correo: String, contrasena: String) {
        val usuario = _usuarioActual.value
        if (usuario?.gmail == correo && usuario.contrasena == contrasena) {
            _mensaje.value = "Inicio de sesión correcto"
        } else {
            _mensaje.value = "Credenciales inválidas"
        }
    }

    fun cerrarSesion() {
        _usuarioActual.value = null
        _mensaje.value = "Sesión cerrada"
    }
}
