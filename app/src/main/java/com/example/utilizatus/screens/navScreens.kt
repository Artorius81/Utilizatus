package com.example.utilizatus.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.utilizatus.R
import com.example.utilizatus.ui.theme.black

@Composable
fun Home() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Главная!",
        style = MaterialTheme.typography.h4.copy(
            color = black,
            letterSpacing = 2.sp,
            fontSize = 32.sp,
            fontFamily = nunitoRegular),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Map() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Карта!",
        style = MaterialTheme.typography.h4.copy(
            color = black,
            letterSpacing = 2.sp,
            fontSize = 32.sp,
            fontFamily = nunitoRegular),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Star() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Лояльность!",
        style = MaterialTheme.typography.h4.copy(
            color = black,
            letterSpacing = 2.sp,
            fontSize = 32.sp,
            fontFamily = nunitoRegular),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Menu() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Меню!",
        style = MaterialTheme.typography.h4.copy(
            color = black,
            letterSpacing = 2.sp,
            fontSize = 32.sp,
            fontFamily = nunitoRegular),
        textAlign = TextAlign.Center
    )
}