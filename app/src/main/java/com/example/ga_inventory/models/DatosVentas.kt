package com.example.ga_inventory.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ventas")
data class DatosVentas(
    @PrimaryKey(autoGenerate = true)
    val idVenta: Int = 0,
    val fechaVenta: String,
    val montoVenta: Double
)
