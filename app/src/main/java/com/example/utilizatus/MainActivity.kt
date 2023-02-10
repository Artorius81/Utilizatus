package com.example.utilizatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.example.utilizatus.screens.Buttons
import com.example.utilizatus.screens.LoginPage
import com.example.utilizatus.screens.OnBoardingScreen
import com.example.utilizatus.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.splashScreenTheme)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)
        setContent {
            UtilizatusTheme {
                OnBoardingScreen()
                //LoginPage()
                //Buttons()
            }
        }
    }
}