package com.example.levelupgamerapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.levelupgamerapp.data.local.dao.ProductoDao
import com.example.levelupgamerapp.data.local.dao.UsuarioDao
import com.example.levelupgamerapp.data.local.entity.UsuarioEntity
import com.example.levelupgamerapp.data.local.entity.ProductoEntity

@Database(
    entities = [UsuarioEntity::class, ProductoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun usuarioDao(): UsuarioDao
    abstract fun productoDao(): ProductoDao
}