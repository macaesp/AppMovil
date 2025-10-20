package com.example.levelupgamerapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class ProductoEntity(
    @PrimaryKey val id: Int,
    val nombre: String,
    val precio: Int,
    val categoria: String,
    val descripcion: String,
    val imagen: String
)
