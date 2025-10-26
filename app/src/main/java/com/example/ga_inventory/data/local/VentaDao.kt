package com.example.ga_inventory.data.local

import androidx.room.*
import com.example.ga_inventory.models.DatosVentas

@Dao
interface VentaDao {

    @Query("SELECT * FROM ventas")
    suspend fun obtenerVentas(): List<DatosVentas>

    @Query("SELECT * FROM ventas WHERE idVenta = :idVenta LIMIT 1")
    suspend fun obtenerVentaPorId(idVenta: Int): DatosVentas?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarVenta(venta: DatosVentas): Long

    @Delete
    suspend fun eliminarVenta(venta: DatosVentas)

    @Query("DELETE FROM ventas WHERE idVenta = :idVenta")
    suspend fun eliminarVentaPorId(idVenta: Int)
}

