package com.example.ga_inventory.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ga_inventory.data.local.AppDatabase
import com.example.ga_inventory.views.proveedores.ProveedoresScreen
import com.example.ga_inventory.views.splash.SplashView

@Composable
fun NavManager(db: AppDatabase) {
    val navController = rememberNavController()

    //Por implementar
    val inicioViewModel=InicioViewModel()
    val menuViewModel=MenuViewModel()
    val ventasViewModel=VentasViewModel()
    val reportesViewModel=ReportesViewModel()

    val productosViewModel=ProductosViewModel()

    val proveedorRepository=ProveedorRepository(db.proveedorDao())
    val proveedorViewModel=ProveedorViewModel(proveedorRepository)


    NavHost(
        navController= navController,
        startDestination = Views.SplashView.route //Primera ventana al usuario
    ){
        composable(Views.SplashView.route){
            SplashView(navController)
        }

        composable(Views.InicioView.route){
            InicioView(navController,inicioViewModel)
        }

        composable(Views.MenuView.route){
            MenuView(navController,
                menuViewModel,
                inicioViewModel
            )
        }

        composable(Views.ProductosView.route){
            ProductosView(navController,productosViewModel)
        }

        composable(Views.VentasView.route){
            VentasView(navController,ventasViewModel)
        }

        composable(Views.ProveedoresView.route){
            ProveedoresScreen(
                navController,
                proveedoresViewModel
            )
        }

        composable(Views.ReportesView.route){
            ReportesView(navController,reportesViewModel)
        }

    }
}