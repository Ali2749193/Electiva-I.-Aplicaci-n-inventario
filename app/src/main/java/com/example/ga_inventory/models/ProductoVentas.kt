package com.example.ga_inventory.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos_venta")
data class ProductoVentas(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idVenta: Int, // Foreign Key manual hacia DatosVentas
    val codigo: String,
    val nombre: String,
    val precioUnitario: Double,
    val cantidad: Int
)
