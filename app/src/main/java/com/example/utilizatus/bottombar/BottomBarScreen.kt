package com.example.utilizatus.bottombar

import com.example.utilizatus.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "Главная",
        icon = R.drawable.home
    )

    object Map : BottomBarScreen(
        route = "MAP",
        title = "Карта",
        icon = R.drawable.map
    )

    object Star : BottomBarScreen(
        route = "STAR",
        title = "Бонусы",
        icon = R.drawable.star
    )

    object Menu : BottomBarScreen(
        route = "MENU",
        title = "Меню",
        icon = R.drawable.menu
    )
}