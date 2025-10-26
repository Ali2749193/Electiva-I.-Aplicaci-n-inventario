package com.example.ga_inventory.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Permisos(){
    val permissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
    )

    //Corrutina para lanzar permisos
    LaunchedEffect(key1= Unit) {
        permissions.launchMultiplePermissionRequest()
    }
}
