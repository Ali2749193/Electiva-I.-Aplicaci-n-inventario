package com.example.ga_inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ga_inventory.data.local.AppDatabase
import com.example.ga_inventory.data.local.DatabaseProvider
import com.example.ga_inventory.navigation.NavManager
import com.example.ga_inventory.ui.theme.GA_inventoryTheme

class MainActivity : ComponentActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        db= DatabaseProvider.getDatabase(this)

        setContent {
            GA_inventoryTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavManager(db) // Configuración de la navegación
                }
            }
        }
    }
}
