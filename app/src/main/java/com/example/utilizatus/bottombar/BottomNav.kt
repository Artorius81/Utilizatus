package com.example.utilizatus.bottombar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
        backgroundColor = MaterialTheme.colors.background,
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
                Text(text = stringResource(item.title))
            },
            selectedContentColor = greenMain,
            unselectedContentColor = secGrey
        )
        }
    }
}