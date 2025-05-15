package com.example.planetapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.planetapp.models.planetList
import com.example.planetapp.ui.components.BottomNavigationBar
import com.example.planetapp.ui.components.TopAppBarWithMenu
import com.example.planetapp.ui.screens.*
import androidx.compose.foundation.layout.padding


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(onSettingsClick: () -> Unit, onHelpClick: () -> Unit) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBarWithMenu(
                onSettingsClick = onSettingsClick,
                onHelpClick = onHelpClick
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                HomeScreen(onPlanetClick = {
                    navController.navigate("details/${it.id}")
                })
            }
            composable("favorites") {
                FavoritesScreen(onPlanetClick = {
                    navController.navigate("details/${it.id}")
                })
            }
            composable(
                route = "details/{planetId}",
                arguments = listOf(navArgument("planetId") { type = NavType.IntType })
            ) { backStackEntry ->
                val planetId = backStackEntry.arguments?.getInt("planetId")
                val planet = planetList.find { it.id == planetId }
                planet?.let {
                    DetailsScreen(planet = it)
                }
            }
        }
    }
}
