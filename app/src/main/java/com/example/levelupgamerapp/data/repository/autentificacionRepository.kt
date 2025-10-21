package com.example.levelupgamerapp.repository

import com.example.levelupgamerapp.data.util.Resultado
import com.example.levelupgamerapp.local.dao.UsuarioDao
import com.example.levelupgamerapp.model.Usuario

class AutentificacionRepository(private val usuarioDao: UsuarioDao) {

    // Registrar un nuevo usuario
    suspend fun registrarUsuario(usuario: Usuario): Resultado<Boolean> {
        val existente = usuarioDao.getUsuarioPorEmail(usuario.gmail)
        return if (existente == null) {
            usuarioDao.insertarUsuario(usuario)
            Resultado.Logrado(true)
        } else {
            Resultado.Error("El usuario ya existe.")
        }
    }

    // Iniciar sesión
    suspend fun iniciarSesion(email: String, password: String): Resultado<Usuario> {
        val usuario = usuarioDao.getUsuarioPorEmail(email)
        return if (usuario != null && usuario.contrasena == password) {
            Resultado.Logrado(usuario)
        } else {
            Resultado.Error("Credenciales incorrectas.")
        }
    }

    // Obtener todos los usuarios (opcional, para depuración o admin)
    suspend fun obtenerUsuarios(): List<Usuario> {
        return usuarioDao.getTodosUsuarios()
    }
}
