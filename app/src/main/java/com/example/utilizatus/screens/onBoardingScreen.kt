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

@Composable
fun OnBoardingScreen() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    Box(modifier = Modifier
        .fillMaxSize()
        .background(white)) {
        Column(modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                ImageVector.vectorResource(id = R.drawable.sort_onboard),
                contentDescription = "Blob",
                modifier = Modifier
                    .size(250.dp)
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(modifier = Modifier,
                    text = stringResource(R.string.sort),
                    style = MaterialTheme.typography.h4.copy(
                        color = greenMain,
                        letterSpacing = 2.sp,
                        fontSize = 24.sp,
                        fontFamily = nunitoBold
                    )
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier.width(300.dp), contentAlignment = Alignment.Center) {
                    Text(modifier = Modifier,
                        text = stringResource(R.string.sort_description),
                        style = MaterialTheme.typography.h4.copy(
                            color = grey,
                            letterSpacing = 2.sp,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            fontFamily = nunitoRegular
                        )
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun Preview() {
    UtilizatusTheme {
        OnBoardingScreen()
    }
}