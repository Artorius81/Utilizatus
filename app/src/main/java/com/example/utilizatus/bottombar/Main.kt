package com.example.utilizatus.bottombar

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.utilizatus.topbar.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Main() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNav(navController = navController) }
    ) {
        NavGraph(navHostController = navController)
    }
}