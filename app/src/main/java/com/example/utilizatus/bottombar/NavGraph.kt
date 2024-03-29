package com.example.utilizatus.bottombar

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.utilizatus.screens.*

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
            Menu(navHostController)
        }
        composable("PROFILE") {
            Profile(navHostController)
        }
    }
}