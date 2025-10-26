package com.example.ga_inventory.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ga_inventory.models.ProductoVentas

@Dao
interface ProductoVentaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarProductoVenta(producto: ProductoVentas)

    @Query("SELECT * FROM productos_venta WHERE idVenta = :idVenta")
    suspend fun obtenerProductosPorVenta(idVenta: Int): List<ProductoVentas>

    @Query("DELETE FROM productos_venta WHERE idVenta = :idVenta")
    suspend fun eliminarProductosDeVenta(idVenta: Int)

//    @Delete
//    suspend fun eliminarProductoVenta(producto: ProductoVentas)

}