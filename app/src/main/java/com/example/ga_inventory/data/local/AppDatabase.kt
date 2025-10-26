package com.example.ga_inventory.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ga_inventory.models.Producto
import com.example.ga_inventory.models.DatosVentas
import com.example.ga_inventory.models.ProductoVentas
import com.example.ga_inventory.models.Proveedor

@Database(
    entities = [
        Producto::class,
        DatosVentas::class,
        ProductoVentas::class,
        Proveedor::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun productoDao(): ProductoDao
    abstract fun ventaDao(): VentaDao
    abstract fun proveedorDao(): ProveedorDao
    abstract fun productoVentaDao(): ProductoVentaDao

}