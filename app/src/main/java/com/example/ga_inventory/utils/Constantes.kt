package com.example.ga_inventory.utils

import com.example.ga_inventory.R
import com.example.ga_inventory.models.Menu

object Constantes {
    const val BASE_URL = "URL_SERVIDOR"
    const val DURACION_SPLASH_SCREEN: Long=4000

    val listMenu=listOf(
        // Falta definir iconos en res
        Menu("productos", R.drawable.boton_producto),
        Menu("proveedores", R.drawable.boton_proveedor),
        Menu("ventas", R.drawable.boton_reportes),
        Menu("reportes", R.drawable.boton_reportes)
    )
}