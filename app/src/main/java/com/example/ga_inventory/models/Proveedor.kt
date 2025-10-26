package com.example.ga_inventory.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proveedores")
data class Proveedor(
    @PrimaryKey(autoGenerate = true)
    val idProveedor: Int=0,

    val nombre: String="",
    val email: String ="",
    val telefono: String="",
    val direccion: String=""
){
    override fun toString(): String{
        return nombre
    }
}
