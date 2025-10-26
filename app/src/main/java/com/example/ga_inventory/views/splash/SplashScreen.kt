package com.example.ga_inventory.views.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ga_inventory.navigation.Views
import com.example.ga_inventory.utils.Constantes
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController){

    LaunchedEffect(key1=true){
        delay(Constantes.DURACION_SPLASH_SCREEN)
        navController.popBackStack() // Quitar splash de la pila
        navController.navigate(Views.MenuView.route) //Inicio y menu son distintos
    }
    SplashView()
}

@Composable
fun SplashView(){
    //Definimos la vista
    Column (
        modifier= Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter= painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )
        Text(
            "GA Inventory",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashViewPreview(){
    SplashView()
}