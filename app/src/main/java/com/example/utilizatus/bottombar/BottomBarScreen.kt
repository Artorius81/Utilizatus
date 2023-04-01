package com.example.utilizatus.bottombar

import androidx.compose.ui.res.stringResource
import com.example.utilizatus.R

sealed class BottomBarScreen(
    val route: String,
    val title: Int,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = R.string.main,
        icon = R.drawable.home
    )

    object Map : BottomBarScreen(
        route = "MAP",
        title = R.string.map,
        icon = R.drawable.map
    )

    object Star : BottomBarScreen(
        route = "STAR",
        title = R.string.bonuses,
        icon = R.drawable.star
    )

    object Menu : BottomBarScreen(
        route = "MENU",
        title = R.string.menu,
        icon = R.drawable.menu
    )
}