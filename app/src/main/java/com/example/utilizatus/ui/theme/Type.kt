package com.example.utilizatus.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.utilizatus.R

private val Nunito = FontFamily(
    Font(R.font.nunito_regular),
    Font(R.font.nunito_italic, style = FontStyle.Italic),
    Font(R.font.nunito_light, weight = FontWeight.Light),
    Font(R.font.nunito_bold, weight = FontWeight.Bold),
    Font(R.font.nunito_medium, weight = FontWeight.Medium),
    Font(R.font.nunito_semibold, weight = FontWeight.SemiBold),
    )

val Typography = Typography(
    defaultFontFamily = Nunito
)