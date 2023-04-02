package com.example.utilizatus.bottombar

import android.content.res.Resources
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.utilizatus.screens.Home
import com.example.utilizatus.screens.Map
import com.example.utilizatus.screens.Menu
import com.example.utilizatus.screens.Star

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "HOME") {
        composable("HOME") {
            Home()
        }
        composable("MAP") {
            Map()
        }
        composable("STAR") {
            Star()
        }
        composable("MENU") {
            Menu()
        }
    }
}