// ui/screens/FavoritesScreen.kt
package com.example.planetapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.planetapp.models.Planet
import com.example.planetapp.models.planetList
import com.example.planetapp.ui.components.PlanetListItem

@Composable
fun FavoritesScreen(onPlanetClick: (Planet) -> Unit) {
    val favorites = planetList.filter { it.isFavorite }
    LazyColumn {
        items(favorites) { planet ->
            PlanetListItem(planet = planet) {
                onPlanetClick(planet)
            }
        }
    }
}