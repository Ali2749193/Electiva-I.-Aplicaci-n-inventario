package com.example.ga_inventory.data.local

import androidx.room.*
import com.example.ga_inventory.models.Producto

@Dao
interface ProductoDao {

    @Query("SELECT * FROM productos")
    suspend fun obtenerProductos(): List<Producto>

    // Obtener resultado sobre un producto específico
    @Query("SELECT * FROM productos WHERE codigoProducto = :codigoProducto LIMIT 1")
    suspend fun obtenerProducto(codigoProducto: String): Producto?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarProducto(producto: Producto)

    @Update
    suspend fun actualizarProducto(producto: Producto)

    @Delete
    suspend fun eliminarProducto(producto: Producto)
}
