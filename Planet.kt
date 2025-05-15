package com.example.planetapp.models

import com.example.planetapp.R

data class Planet(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)

val planetList = listOf(
    Planet(1, "Mercúrio", "É o planeta mais próximo do Sol e o menor do sistema solar.", R.drawable.mercurio),
    Planet(2, "Vênus", "Segundo planeta mais próximo do Sol, com atmosfera densa e quente.", R.drawable.venus),
    Planet(3, "Terra", "Nosso planeta natal, o único conhecido por abrigar vida.", R.drawable.terra)
)