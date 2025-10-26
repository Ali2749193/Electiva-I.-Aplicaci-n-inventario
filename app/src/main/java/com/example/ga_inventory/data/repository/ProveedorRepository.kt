package com.example.ga_inventory.data.repository

import com.example.ga_inventory.data.local.ProveedorDao
import com.example.ga_inventory.models.Proveedor

class ProveedorRepository(private val proveedorDao: ProveedorDao) {

    // READ
    suspend fun obtenerProveedores(): List<Proveedor> =
        proveedorDao.obtenerProveedores()

    suspend fun agregarProveedor(proveedor: Proveedor) =
        proveedorDao.agregarProveedor(proveedor)

    suspend fun actualizarProveedor(proveedor: Proveedor) =
        proveedorDao.actualizarProveedor(proveedor)

    suspend fun eliminarProveedor(proveedor: Proveedor) =
        proveedorDao.eliminarProveedor(proveedor)
}
