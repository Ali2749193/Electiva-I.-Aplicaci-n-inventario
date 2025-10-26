package com.example.ga_inventory.data.repository

import com.example.ga_inventory.data.local.ProductoDao
import com.example.ga_inventory.models.Producto

class ProductoRepository(private val productoDao: ProductoDao) {

    // Obtener lista completa de productos
    suspend fun obtenerProductos(): List<Producto> {
        return productoDao.obtenerProductos()
    }

    // Obtener un producto específico por su código
    suspend fun obtenerProducto(codigoProducto: String): Producto? {
        return productoDao.obtenerProducto(codigoProducto)
    }

    // Agregar nuevo producto
    suspend fun agregarProducto(producto: Producto) {
        productoDao.agregarProducto(producto)
    }

    // Actualizar un producto existente
    suspend fun actualizarProducto(producto: Producto) {
        productoDao.actualizarProducto(producto)
    }

    // Eliminar un producto existente
    suspend fun eliminarProducto(producto: Producto) {
        productoDao.eliminarProducto(producto)
    }
}
