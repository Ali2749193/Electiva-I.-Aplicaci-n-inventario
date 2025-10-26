package com.example.ga_inventory.views.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ga_inventory.models.Proveedor

@Composable
fun ProveedorCard(
    proveedor: Proveedor,
    onDelete: (Proveedor) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(proveedor.nombre, style = MaterialTheme.typography.titleSmall)
                Text(proveedor.email, style = MaterialTheme.typography.bodySmall)
                Text(proveedor.telefono, style = MaterialTheme.typography.bodySmall)
                Text(proveedor.direccion, style = MaterialTheme.typography.bodySmall)
            }

            IconButton(onClick = { onDelete(proveedor) }) {
                Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
            }
        }
    }
}