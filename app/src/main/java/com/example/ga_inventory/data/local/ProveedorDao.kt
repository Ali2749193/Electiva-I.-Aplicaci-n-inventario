package com.example.ga_inventory.data.local

import androidx.room.*
import com.example.ga_inventory.models.Proveedor

@Dao
interface ProveedorDao {

    @Query("SELECT * FROM proveedores")
    suspend fun obtenerProveedores(): List<Proveedor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarProveedor(proveedor: Proveedor)

    @Update
    suspend fun actualizarProveedor(proveedor: Proveedor)

    @Delete
    suspend fun eliminarProveedor(proveedor: Proveedor)
}
