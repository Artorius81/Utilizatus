package com.example.utilizatus

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.utilizatus.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.splashScreenTheme)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)
        setContent {
            UtilizatusTheme {
                LoginPage()
                BottomSheet()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginPage() {
    val nunito_bold = FontFamily(Font(R.font.nunito_bold))
    val nunito_regular = FontFamily(Font(R.font.nunito_regular))

    var password by remember { mutableStateOf(("")) }
    var email by remember { mutableStateOf(("")) }
    val keyboardController = LocalSoftwareKeyboardController.current


    Box(modifier = Modifier
        .fillMaxSize()
        .background(white)) {
        Box(modifier = Modifier
            .background(white)
        ){
            Image(ImageVector.vectorResource(id = R.drawable.blob),
                contentDescription = "Blob",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth())
            Column(modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier
                    .width(400.dp),
                    text = stringResource(R.string.tip),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h4.copy(
                        color = greenMain,
                        letterSpacing = 2.sp,
                        fontSize = 24.sp,
                        fontFamily = nunito_bold
                    )
                )
            }
            Text(modifier = Modifier
                .padding(top = 70.dp, start = 50.dp),
                text = stringResource(R.string.greetings),
                style = MaterialTheme.typography.h4.copy(
                    color = white,
                    letterSpacing = 5.sp,
                    fontSize = 36.sp,
                    fontFamily = nunito_bold
                )
            )
            Text(modifier = Modifier
                .padding(top = 120.dp, start = 50.dp),
                text = stringResource(R.string.slogan),
                style = MaterialTheme.typography.h4.copy(
                    color = white,
                    letterSpacing = 2.sp,
                    fontSize = 14.sp,
                    fontFamily = nunito_regular
                )
            )
        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet() {
    val FastOutLinearInEasing: Easing = CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f)

        rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 0,
                easing = FastOutLinearInEasing
            )
        )
    val nunito_bold = FontFamily(Font(R.font.nunito_bold))
    val nunito_regular = FontFamily(Font(R.font.nunito_regular))
    BottomSheetScaffold(
        sheetContent = {
        Card(
            backgroundColor = white,
            modifier = Modifier
                .fillMaxWidth()
                .height(630.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Image(ImageVector.vectorResource(id = R.drawable.arr),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .height(40.dp)
                        .size(35.dp)
                        .fillMaxWidth())
            }
        }
    }, scaffoldState = rememberBottomSheetScaffoldState(), sheetBackgroundColor = white, sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp), sheetPeekHeight = 50.dp) {
        LoginPage()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginPage()
    BottomSheet()
}

@Composable
fun Fsdf() {
    var selected by remember { mutableStateOf(true) }
    var non_selected by remember { mutableStateOf(true) }
    Row(modifier = Modifier
        .padding(top = 150.dp)) {
        Crossfade(targetState = selected, animationSpec = tween(500)) { isSelected ->
            if (isSelected) {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (selected) greenMain else white),
                    modifier = Modifier
                        .padding(top = 300.dp, start = 50.dp)
                ) {
                    Text("По логину", color = if (selected) white else grey, fontSize = 16.sp,)
                }
            }
            else {
                Button(
                    onClick = { selected = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (selected) greenMain else white),
                    modifier = Modifier
                        .padding(top = 300.dp, start = 50.dp)
                ) {
                    Text("По логину", color = if (selected) white else grey, fontSize = 16.sp,)
                }
            }
        }

        Spacer(modifier = Modifier
            .padding(20.dp))

        Crossfade(targetState = non_selected, animationSpec = tween(500), modifier = Modifier) { isNonSelected ->
            if (isNonSelected) {
                Button(
                    onClick = { selected = false },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (selected) white else greenMain),
                    modifier = Modifier
                        .padding(top = 300.dp)
                ) {
                    Text("По номеру", color = if (selected) grey else white, fontSize = 16.sp,)
                }
            } else {
                Button(
                    onClick = { selected = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (selected) greenMain else white),
                    modifier = Modifier
                        .padding(top = 300.dp)
                ) {
                    Text("По номеру", color = if (selected) white else grey, fontSize = 16.sp,)
                }
            }
        }
    }
}