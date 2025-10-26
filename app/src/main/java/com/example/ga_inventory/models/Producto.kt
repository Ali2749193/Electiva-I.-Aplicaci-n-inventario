package com.example.ga_inventory.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "productos",
    foreignKeys = [
        ForeignKey(
            entity = Proveedor::class,
            parentColumns = ["idProveedor"],
            childColumns = ["proveedorId"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val idProducto: Int = 0,

    val codigoProducto: String,
    val nombreProducto: String,
    val descripcion: String,
    val subcategoria: String,
    val precioUnitario: Double,
    val cantidadAlmacen: Int,
    val proveedorId: Int? = null // clave foránea opcional
)
