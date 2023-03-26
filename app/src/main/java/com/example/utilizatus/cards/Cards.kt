package com.example.utilizatus.cards

data class Item(
    val id: Int,
    val name: String,
    val icon: Int,
    val color: androidx.compose.ui.graphics.Color
    )

data class CardMore(
    val id: Int,
    val name: String,
    val icon: Int,
    val type: IntArray
)

data class CardPopular(
    val id: Int,
    val name: String,
    val icon: Int,
    val desc: String
)