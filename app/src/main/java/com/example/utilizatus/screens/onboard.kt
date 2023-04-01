@file:OptIn(ExperimentalPagerApi::class)

package com.example.utilizatus.screens

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.utilizatus.R
import com.example.utilizatus.ui.theme.UtilizatusTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.utilizatus.HomeActivity
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.utilizatus.model.onboardPages
import com.example.utilizatus.ui.theme.greenMain
import com.example.utilizatus.view.OnBoardingScreen

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingUi() {

    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val pagerState = rememberPagerState(3)
    val context = LocalContext.current
    val launchActivity = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult -> }

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
                    onClick = { launchActivity.launch(Intent(context, HomeActivity::class.java)) },
                    border = BorderStroke(1.dp, greenMain),
                ) {

                    Text(modifier = Modifier,
                        text = stringResource(R.string.begin),
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