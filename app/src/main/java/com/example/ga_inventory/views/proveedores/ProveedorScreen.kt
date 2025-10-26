package com.example.ga_inventory.views.proveedores

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ga_inventory.models.Proveedor
import com.example.ga_inventory.viewmodels.ProveedorViewModel
import com.example.ga_inventory.views.cards.ProveedorCard

@Composable
fun ProveedoresScreen(
    navController: NavController,
    viewModel: ProveedorViewModel
) {
    val proveedores by viewModel.proveedores.collectAsState(initial = emptyList())

    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Registrar nuevo proveedor",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = telefono, onValueChange = { telefono = it }, label = { Text("Teléfono") })
        TextField(value = direccion, onValueChange = { direccion = it }, label = { Text("Dirección") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nombre.isNotBlank()) {
                    viewModel.agregarProveedor(
                        Proveedor(
                            nombre = nombre,
                            email = email,
                            telefono = telefono,
                            direccion = direccion
                        )
                    )
                    // Limpia los campos
                    nombre = ""
                    email = ""
                    telefono = ""
                    direccion = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Guardar proveedor")
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = DividerDefaults.Thickness,
            color = DividerDefaults.color
        )

        Text(
            text = "Lista de proveedores registrados",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(proveedores) { proveedor ->
                ProveedorCard(
                    proveedor = proveedor,
                    onDelete = { viewModel.eliminarProveedor(it) }
                )
            }
        }
    }
}

