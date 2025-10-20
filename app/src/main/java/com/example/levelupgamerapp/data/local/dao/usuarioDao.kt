package com.example.levelupgamerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.levelupgamerapp.data.local.entity.UsuarioEntity

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun registroUsuario(usuario: UsuarioEntity)

    @Query("SELECT * FROM usuarios WHERE gmail = :gmail AND contrasena = :contrasena LIMIT 1")
    suspend fun logear(gmail: String, contrasena: String): UsuarioEntity?

    @Query("SELECT * FROM usuarios WHERE gmail = :gmail LIMIT 1")
    suspend fun obtenerUsuarioPorGmail(gmail: String): UsuarioEntity?

}