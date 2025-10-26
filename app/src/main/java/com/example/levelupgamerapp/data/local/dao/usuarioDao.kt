package com.example.levelupgamerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.levelupgamerapp.data.local.entity.UsuarioEntity

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarUsuario(usuario: UsuarioEntity)

    @Query("SELECT * FROM usuarios WHERE gmail = :email LIMIT 1")
    suspend fun getUsuarioPorEmail(email: String): UsuarioEntity?

    @Query("SELECT * FROM usuarios")
    suspend fun getTodosUsuarios(): List<UsuarioEntity>
}
