// ui/components/TopAppBarWithMenu.kt
package com.example.planetapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.example.planetapp.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithMenu(onSettingsClick: () -> Unit, onHelpClick: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(text = { Text("Configurações") }, onClick = {
                    expanded = false
                    onSettingsClick()
                })
                DropdownMenuItem(text = { Text("Ajuda") }, onClick = {
                    expanded = false
                    onHelpClick()
                })
            }
        }
    )
}