package com.example.utilizatus.bottombar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.utilizatus.ui.theme.*

@Composable
fun BottomNav(navController: NavController) {
    val listItems = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Map,
        BottomBarScreen.Star,
        BottomBarScreen.Menu
    )
    BottomNavigation(
        backgroundColor = white,
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 0.dp, 0.dp))
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach{
            item -> BottomNavigationItem(
            selected = currentRoute == item.route,
            onClick = { navController.navigate(item.route) },
            icon = {
                Icon(painter = painterResource(id = item.icon), contentDescription = "icon")
            },
            label = {
                Text(text = item.title)
            },
            selectedContentColor = greenMain,
            unselectedContentColor = secGrey
        )
        }
    }
}