package com.example.levelupgamerapp.data.repository

import com.example.levelupgamerapp.data.local.dao.UsuarioDao
import com.example.levelupgamerapp.data.local.entity.UsuarioEntity
import com.example.levelupgamerapp.data.util.Resultado
import com.example.levelupgamerapp.model.Usuario

private fun Usuario.toEntity() = UsuarioEntity(id = id, usuario = usuario, gmail = gmail, contrasena = contrasena)
private fun UsuarioEntity.toModel() = Usuario(id = id, usuario = usuario, gmail = gmail, contrasena = contrasena)

class AutentificacionRepository(private val usuarioDao: UsuarioDao) {

    suspend fun registrarUsuario(usuario: Usuario): Resultado<Boolean> {
        val existente = usuarioDao.getUsuarioPorEmail(usuario.gmail)
        return if (existente == null) {
            usuarioDao.insertarUsuario(usuario.toEntity())
            Resultado.Logrado(true)
        } else {
            Resultado.Error("El usuario ya existe.")
        }
    }

    suspend fun iniciarSesion(email: String, password: String): Resultado<Usuario> {
        val usuario = usuarioDao.getUsuarioPorEmail(email)
        return if (usuario != null && usuario.contrasena == password) {
            Resultado.Logrado(usuario.toModel())
        } else {
            Resultado.Error("Credenciales incorrectas.")
        }
    }

    suspend fun obtenerUsuarios(): List<Usuario> {
        return usuarioDao.getTodosUsuarios().map { it.toModel() }
    }
}
