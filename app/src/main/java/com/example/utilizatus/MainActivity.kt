package com.example.utilizatus

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.airbnb.lottie.compose.*
import com.example.utilizatus.ui.theme.*
import com.togitech.ccp.component.TogiCountryCodePicker
import compose.icons.FeatherIcons
import compose.icons.feathericons.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.splashScreenTheme)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)
        setContent {
            UtilizatusTheme {
                LoginPage()
                Buttons()
            }
        }
    }
}

@Composable
fun LottieAnim() {
    val compotionResult : LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.anim)
    )
    val progressAnimation by animateLottieCompositionAsState(
        compotionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )
    LottieAnimation(composition = compotionResult.value, progress = progressAnimation)
}

@Composable
fun LoginPage() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))


    Box(modifier = Modifier
        .fillMaxSize()
        .background(white)) {
        Box(modifier = Modifier
            .background(white)
        ){
            Column(modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            }
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
                LottieAnim()
            }
            Image(ImageVector.vectorResource(id = R.drawable.blob),
                contentDescription = "Blob",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth())
            Text(modifier = Modifier
                .padding(top = 70.dp, start = 50.dp),
                text = stringResource(R.string.greetings),
                style = MaterialTheme.typography.h4.copy(
                    color = white,
                    letterSpacing = 5.sp,
                    fontSize = 36.sp,
                    fontFamily = nunitoBold
                )
            )
            Text(modifier = Modifier
                .padding(top = 120.dp, start = 50.dp),
                text = stringResource(R.string.slogan),
                style = MaterialTheme.typography.h4.copy(
                    color = white,
                    letterSpacing = 2.sp,
                    fontSize = 12.sp,
                    fontFamily = nunitoRegular
                )
            )
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun BottomSheet(selectedButton: Button, onButtonSelected: (Button) -> Unit) {
    val login = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val uriHandler = LocalUriHandler.current

    val state = remember { mutableStateOf(selectedButton) }
    val type = remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
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
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier
                    .height(50.dp)) {
                    Image(ImageVector.vectorResource(id = R.drawable.util_logo),
                        contentDescription = "logo",
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .size(30.dp)
                            .fillMaxWidth())
                    Spacer(modifier = Modifier
                        .padding(2.dp))
                    Text(text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.h4.copy(
                            color = greenMain,
                            letterSpacing = 2.sp,
                            fontSize = 32.sp,
                            fontFamily = nunitoRegular)
                    )
                }
                Spacer(modifier = Modifier
                    .padding(5.dp))
                Column(modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(modifier = Modifier) {
                        TextButton(
                            onClick = {
                                onButtonSelected(Button.First)
                                state.value = Button.First
                                type.value = false
                            },
                            interactionSource = NoRippleInteractionSource(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (state.value == Button.First) {
                                greenMain
                            } else {
                                white
                            }),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                        ) {
                            Text(text = stringResource(R.string.login_type),
                                style = MaterialTheme.typography.h4.copy(
                                    color = if (state.value == Button.First) {
                                        white
                                    } else {
                                        black },
                                    letterSpacing = 2.sp,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular))
                        }
                        Spacer(modifier = Modifier
                            .padding(30.dp))
                        TextButton(
                            onClick = {
                                onButtonSelected(Button.Second)
                                state.value = Button.Second
                                type.value = true
                            },
                            interactionSource = NoRippleInteractionSource(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (state.value == Button.Second) {
                                greenMain
                            } else {
                                white
                            }),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                        ) {
                            Text(text = stringResource(R.string.pass_type),
                                style = MaterialTheme.typography.h4.copy(
                                    color = if (state.value == Button.Second) {
                                        white
                                    } else {
                                        black },
                                    letterSpacing = 2.sp,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular))
                        }
                    }
                        if (type.value) {
                            TogiCountryCodePicker(
                                text = phoneNumber.value,
                                onValueChange = { phoneNumber.value = it },
                                unfocusedBorderColor = white,
                                modifier = Modifier
                                    .width(315.dp),
                                focusedBorderColor = white,
                                cursorColor = secGrey,
                                bottomStyle = false, //  if true the text-field is below the country code selector at the top.
                                shape = RoundedCornerShape(8.dp)
                            )
                            Spacer(modifier = Modifier.padding(41.dp))
                            Button(
                                onClick = {},
                                interactionSource = NoRippleInteractionSource(),
                                colors = ButtonDefaults.buttonColors(backgroundColor = greenMain),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                            ) {
                                Text(text = stringResource(R.string.next),
                                    style = MaterialTheme.typography.h4.copy(
                                        color = white,
                                        letterSpacing = 4.sp,
                                        fontSize = 28.sp,
                                        fontFamily = nunitoRegular))
                            }
                            TextButton(
                                onClick = {},
                                interactionSource = NoRippleInteractionSource(),
                                colors = ButtonDefaults.buttonColors(backgroundColor = white),
                                modifier = Modifier
                            ) {
                                Text(text = stringResource(R.string.registration),
                                    style = MaterialTheme.typography.h4.copy(
                                        color = greenMain,
                                        letterSpacing = 2.sp,
                                        fontSize = 14.sp,
                                        fontFamily = nunitoRegular))
                            }
                            Spacer(modifier = Modifier.padding(35.dp))
                            Text(text = stringResource(R.string.enter_with),
                                style = MaterialTheme.typography.h4.copy(
                                    color = grey,
                                    letterSpacing = 2.sp,
                                    fontSize = 18.sp,
                                    fontFamily = nunitoBold))
                            Column(modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally) {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.Center) {
                                    Image(ImageVector.vectorResource(id = R.drawable.gosuslugi_logo),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .clickable { uriHandler.openUri("https://www.gosuslugi.ru/") }
                                            .size(40.dp))
                                    Spacer(modifier = Modifier.padding(25.dp))
                                    Image(ImageVector.vectorResource(id = R.drawable.vk_logo),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .clickable { uriHandler.openUri("https://vk.com/artorius81") }
                                            .size(40.dp))
                                    Spacer(modifier = Modifier.padding(25.dp))
                                    Image(ImageVector.vectorResource(id = R.drawable.ok_logo),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .clickable { uriHandler.openUri("https://ok.ru/") }
                                            .size(40.dp))
                                }
                            }
                        } else {
                            TextField(
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    backgroundColor = white,
                                    textColor = greenMain,
                                    cursorColor = secGrey,
                                ),
                                textStyle = TextStyle(fontSize = 15.sp),
                                value = login.value,
                                singleLine = true,
                                onValueChange = {
                                    login.value = it
                                },
                                modifier = Modifier
                                    .width(270.dp),
                                leadingIcon = { Icon(imageVector = FeatherIcons.User, contentDescription = "Lock Icon") },
                                placeholder = { Text(text = stringResource(R.string.login),
                                    fontFamily = nunitoRegular,
                                    fontSize = 15.sp,
                                    color = secGrey) },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email,
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = { keyboardController?.hide() }),
                            )
                            Spacer(modifier = Modifier
                                .padding(15.dp))
                            TextField(
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    backgroundColor = white,
                                    textColor = greenMain,
                                    cursorColor = secGrey,
                                ),
                                textStyle = TextStyle(fontSize = 15.sp),
                                value = password.value,
                                singleLine = true,
                                onValueChange = {
                                    password.value = it
                                },
                                modifier = Modifier
                                    .width(270.dp),
                                leadingIcon = { Icon(imageVector = FeatherIcons.Lock, contentDescription = "Pass") },
                                trailingIcon = { IconButton(onClick = { showPassword = !showPassword }) {
                                    Icon(imageVector = if (showPassword) FeatherIcons.Eye else FeatherIcons.EyeOff, contentDescription = "View") }
                                },
                                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                                placeholder = { Text(text = stringResource(R.string.password),
                                    fontFamily = nunitoRegular,
                                    fontSize = 15.sp,
                                    color = secGrey) },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = { keyboardController?.show() }),
                            )
                            Spacer(modifier = Modifier.padding(15.dp))
                            Button(
                                onClick = {},
                                interactionSource = NoRippleInteractionSource(),
                                colors = ButtonDefaults.buttonColors(backgroundColor = greenMain),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                            ) {
                                Text(text = stringResource(R.string.log_in),
                                    style = MaterialTheme.typography.h4.copy(
                                        color = white,
                                        letterSpacing = 4.sp,
                                        fontSize = 28.sp,
                                        fontFamily = nunitoRegular))
                            }
                            TextButton(
                                onClick = {},
                                interactionSource = NoRippleInteractionSource(),
                                colors = ButtonDefaults.buttonColors(backgroundColor = white),
                                modifier = Modifier
                            ) {
                                Text(text = stringResource(R.string.pass_forgot),
                                    style = MaterialTheme.typography.h4.copy(
                                        color = greenMain,
                                        letterSpacing = 2.sp,
                                        fontSize = 14.sp,
                                        fontFamily = nunitoRegular))
                            }
                            TextButton(
                                onClick = {},
                                interactionSource = NoRippleInteractionSource(),
                                colors = ButtonDefaults.buttonColors(backgroundColor = white),
                                modifier = Modifier
                            ) {
                                Text(text = stringResource(R.string.registration),
                                    style = MaterialTheme.typography.h4.copy(
                                        color = greenMain,
                                        letterSpacing = 2.sp,
                                        fontSize = 14.sp,
                                        fontFamily = nunitoRegular))
                            }
                            Spacer(modifier = Modifier.padding(10.dp))
                            Column(modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = stringResource(R.string.enter_with),
                                    style = MaterialTheme.typography.h4.copy(
                                        color = grey,
                                        letterSpacing = 2.sp,
                                        fontSize = 18.sp,
                                        fontFamily = nunitoBold))
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                    horizontalArrangement = Arrangement.Center) {
                                    Image(ImageVector.vectorResource(id = R.drawable.gosuslugi_logo),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .clickable { uriHandler.openUri("https://www.gosuslugi.ru/") }
                                            .size(40.dp))
                                    Spacer(modifier = Modifier.padding(25.dp))
                                    Image(ImageVector.vectorResource(id = R.drawable.vk_logo),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .clickable { uriHandler.openUri("https://vk.com/artorius81") }
                                            .size(40.dp))
                                    Spacer(modifier = Modifier.padding(25.dp))
                                    Image(ImageVector.vectorResource(id = R.drawable.ok_logo),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .clickable { uriHandler.openUri("https://ok.ru/") }
                                            .size(40.dp))
                                }
                            }
                        }
                    }
                }
            }
    }, scaffoldState = rememberBottomSheetScaffoldState(),
        sheetBackgroundColor = white,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetPeekHeight = 50.dp) {
        LoginPage()
    }
}

@Composable
fun Buttons() {
    var selectedButton by remember { mutableStateOf(Button.First) }

    BottomSheet(selectedButton, onButtonSelected = { selectedButton = it })

}

class NoRippleInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true
}

enum class Button {
    First,
    Second
}