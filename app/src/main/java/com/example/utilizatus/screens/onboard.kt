package com.example.utilizatus.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utilizatus.R
import com.example.utilizatus.ui.theme.UtilizatusTheme
import com.example.utilizatus.ui.theme.greenMain
import com.example.utilizatus.ui.theme.grey
import com.example.utilizatus.ui.theme.white
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.utilizatus.model.onboardPages
import com.example.utilizatus.ui.theme.UtilizatusTheme
import com.example.utilizatus.view.HomeUi
import com.example.utilizatus.view.OnBoardingScreen

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingUi() {

    val pagerState = rememberPagerState(3)

    Column {

        HorizontalPager(state = pagerState , modifier = Modifier.fillMaxSize().weight(1f)) {
                page ->
                OnBoardingScreen(page = onboardPages[page])
        }

        HorizontalPagerIndicator(pagerState = pagerState, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(16.dp),
            activeColor = Color.Blue)

        AnimatedVisibility(visible = pagerState.currentPage == 2) {
            OutlinedButton(shape = RoundedCornerShape(20.dp), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),onClick = {}, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(
                id = R.color.purple_500), colorResource(id = R.color.white))) {

                Text(text = "Начать")

            }

        }
    }
}

@Preview
@Composable
fun Preview() {
    UtilizatusTheme {

    }
}