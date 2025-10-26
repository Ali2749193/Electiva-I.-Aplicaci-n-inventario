package com.example.ga_inventory.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ga_inventory.data.repository.ProveedorRepository
import com.example.ga_inventory.models.Proveedor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProveedorViewModel(
    private val repository: ProveedorRepository
) : ViewModel() {

    // Estado observable por Compose
    private val _proveedores = MutableStateFlow<List<Proveedor>>(emptyList())
    val proveedores: StateFlow<List<Proveedor>> = _proveedores

    init {
        // Cargar la lista al iniciar
        obtenerProveedores()
    }

    private fun obtenerProveedores() {
        viewModelScope.launch {
            _proveedores.value = repository.obtenerProveedores()
        }
    }

    fun agregarProveedor(proveedor: Proveedor) {
        viewModelScope.launch {
            repository.agregarProveedor(proveedor)
            obtenerProveedores() // refrescar lista
        }
    }

    fun actualizarProveedor(proveedor: Proveedor) {
        viewModelScope.launch {
            repository.actualizarProveedor(proveedor)
            obtenerProveedores()
        }
    }

    fun eliminarProveedor(proveedor: Proveedor) {
        viewModelScope.launch {
            repository.eliminarProveedor(proveedor)
            obtenerProveedores()
        }
    }
}
