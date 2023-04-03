package com.example.utilizatus

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import com.example.utilizatus.bottombar.Main
import com.example.utilizatus.ui.theme.UtilizatusTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import java.util.*

@ExperimentalPagerApi
class HomeActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalAnimationApi

    private var backPressedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.splashScreenTheme)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)
        setContent {
            UtilizatusTheme {
                Main()
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(this, "Нажмите второй раз для выхода из приложения", Toast.LENGTH_LONG)
                .show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    private fun updateUI() {

    }

    private fun Context.isConnectedToNetwork(): Boolean {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
    }
}