package com.example.ga_inventory.data.repository

import com.example.ga_inventory.data.local.VentaDao
import com.example.ga_inventory.data.local.ProductoVentaDao
import com.example.ga_inventory.models.DatosVentas
import com.example.ga_inventory.models.ProductoVentas

class VentaRepository(
    private val ventaDao: VentaDao,
    private val productoVentaDao: ProductoVentaDao
) {

    // Obtener todas las ventas
    suspend fun obtenerVentas(): List<DatosVentas> {
        return ventaDao.obtenerVentas()
    }

    // Obtener una venta específica (sin los productos)
    suspend fun obtenerVentaPorId(idVenta: Int): DatosVentas? {
        return ventaDao.obtenerVentaPorId(idVenta)
    }

    // Insertar nueva venta y sus productos asociados
    suspend fun registrarVentaConProductos(
        venta: DatosVentas,
        productos: List<ProductoVentas>
    ) {
        val idVenta = ventaDao.insertarVenta(venta)
        productos.forEach { producto ->
            productoVentaDao.insertarProductoVenta(
                producto.copy(idVenta = idVenta.toInt())
            )
        }
    }

    // Obtener productos asociados a una venta
    suspend fun obtenerProductosDeVenta(idVenta: Int): List<ProductoVentas> {
        return productoVentaDao.obtenerProductosPorVenta(idVenta)
    }

    // Eliminar una venta y sus productos asociados
    suspend fun eliminarVenta(idVenta: Int) {
        productoVentaDao.eliminarProductosDeVenta(idVenta)
        ventaDao.eliminarVentaPorId(idVenta)
    }
}
