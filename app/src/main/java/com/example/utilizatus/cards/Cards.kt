package com.example.utilizatus.cards

import android.annotation.SuppressLint

data class Item(
    val id: Int,
    val name: String,
    val icon: Int,
    val color: androidx.compose.ui.graphics.Color
    )

@SuppressLint("SupportAnnotationUsage")
data class CardMore(
    val id: Int,
    val name: String,
    val icon: Int,
    val description: String,
    val type: IntArray
)

data class CardPopular(
    val id: Int,
    val name: String,
    val icon: Int,
    val desc: String
)