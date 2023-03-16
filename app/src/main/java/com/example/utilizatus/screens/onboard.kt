@file:OptIn(ExperimentalPagerApi::class)

package com.example.utilizatus.screens

import androidx.compose.animation.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.utilizatus.R
import com.example.utilizatus.ui.theme.UtilizatusTheme
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.utilizatus.model.onboardPages
import com.example.utilizatus.ui.theme.greenMain
import com.example.utilizatus.ui.theme.grey
import com.example.utilizatus.ui.theme.white
import com.example.utilizatus.view.OnBoardingScreen

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingUi() {

    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val pagerState = rememberPagerState(3)

    Column {

        HorizontalPager(state = pagerState , modifier = Modifier
            .fillMaxSize()
            .weight(1f)) {
                page ->
                OnBoardingScreen(page = onboardPages[page])
        }

        HorizontalPagerIndicator(pagerState = pagerState, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(36.dp),
            activeColor = greenMain)

        AnimatedVisibility(visible = pagerState.currentPage == 2) {
            Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
                OutlinedButton(shape = RoundedCornerShape(8.dp), modifier = Modifier
                    .padding(bottom = 46.dp),
                    onClick = {},
                    border = BorderStroke(1.dp, greenMain),
                ) {

                    Text(modifier = Modifier,
                        text = "Начать",
                        style = MaterialTheme.typography.h4.copy(
                            color = greenMain,
                            letterSpacing = 2.sp,
                            textAlign = TextAlign.Center,
                            fontSize = 26.sp,
                            fontFamily = nunitoBold
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun Preview() {
    UtilizatusTheme {
        OnboardingUi()
    }
}