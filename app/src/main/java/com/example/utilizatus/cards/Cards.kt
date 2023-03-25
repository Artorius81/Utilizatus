package com.example.utilizatus.cards

data class Item(
    val id: Int,
    val name: String,
    val icon: Int,
    val color: androidx.compose.ui.graphics.Color
    )

data class Card(
    val id: Int,
    val name: String,
    val icon: Int
)