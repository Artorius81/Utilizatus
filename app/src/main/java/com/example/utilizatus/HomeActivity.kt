package com.example.utilizatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.content.ContextCompat
import com.example.utilizatus.ui.theme.UtilizatusTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
class HomeActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.splashScreenTheme)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)
        setContent {
            UtilizatusTheme {

            }
        }
    }
}