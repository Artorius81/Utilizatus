@file:OptIn(ExperimentalAnimationApi::class)

package com.example.utilizatus.screens

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.utilizatus.R
import com.example.utilizatus.notification.NotificationService
import com.example.utilizatus.notification.OTPNumber
import com.example.utilizatus.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError
import com.togitech.ccp.component.TogiCountryCodePicker
import compose.icons.FeatherIcons
import compose.icons.feathericons.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


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
            Image(
                ImageVector.vectorResource(id = R.drawable.blob),
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

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
@ExperimentalAnimationApi
@ExperimentalPagerApi
@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomSheet(service: NotificationService, selectedButton: Button, onButtonSelected: (Button) -> Unit) {
    val login = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val login_reg = remember { mutableStateOf(TextFieldValue()) }
    val pass_reg = remember { mutableStateOf(TextFieldValue()) }
    val password_check = remember { mutableStateOf(TextFieldValue()) }
    var loginError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var logPassError by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }
    var OTPError by remember { mutableStateOf(false) }
    var registration = remember { mutableStateOf(false) }
    var phoNumbError by remember { mutableStateOf(false) }
    var phoneNumber by remember { mutableStateOf("") }
    val uriHandler = LocalUriHandler.current
    val keyboardController = LocalSoftwareKeyboardController.current

    var otpValue by remember { mutableStateOf("") }
    val state = remember { mutableStateOf(selectedButton) }
    val type = remember { mutableStateOf(false) }
    val OnBoard = remember { mutableStateOf(false) }
    val OTP = remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }
    var showPassword_check by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val interactionSource = remember {
        MutableInteractionSource()
    }
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
                    Image(
                        ImageVector.vectorResource(id = R.drawable.arr),
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .height(40.dp)
                            .size(35.dp)
                            .fillMaxWidth())
                }
                if (registration.value) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                            Image(
                                ImageVector.vectorResource(id = R.drawable.back),
                                contentDescription = "back",
                                modifier = Modifier
                                    .clickable (indication = null, interactionSource = interactionSource) { registration.value = false }
                                    .padding(top = 10.dp)
                                    .size(30.dp))
                            Spacer(modifier = Modifier
                                .padding(20.dp))
                            Image(
                                ImageVector.vectorResource(id = R.drawable.util_logo),
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
                        Spacer(modifier = Modifier.padding(15.dp))
                        TextField(
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                backgroundColor = white,
                                textColor = greenMain,
                                cursorColor = secGrey,
                            ),
                            textStyle = TextStyle(fontSize = 15.sp),
                            value = login_reg.value,
                            singleLine = true,
                            onValueChange = {
                                login_reg.value = it
                            },
                            modifier = Modifier
                                .width(270.dp),
                            leadingIcon = { Icon(imageVector = FeatherIcons.User, contentDescription = "Lock Icon") },
                            placeholder = { Text(text = stringResource(R.string.login),
                                fontFamily = nunitoRegular,
                                fontSize = 15.sp,
                                color = secGrey
                            ) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { focusManager.clearFocus() }),
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
                            value = pass_reg.value,
                            singleLine = true,
                            onValueChange = {
                                pass_reg.value = it
                                pass_reg.value = it
                            },
                            modifier = Modifier
                                .width(270.dp),
                            leadingIcon = { Icon(imageVector = FeatherIcons.Lock, contentDescription = "Pass") },
                            trailingIcon = { IconButton(onClick = { showPassword = !showPassword }) {
                                Icon(imageVector = if (showPassword) FeatherIcons.EyeOff else FeatherIcons.Eye, contentDescription = "View") }
                            },
                            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                            placeholder = { Text(text = stringResource(R.string.password),
                                fontFamily = nunitoRegular,
                                fontSize = 15.sp,
                                color = secGrey
                            ) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { focusManager.clearFocus() }),
                        )
                        Spacer(modifier = Modifier.padding(15.dp))
                        TextField(
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                backgroundColor = white,
                                textColor = greenMain,
                                cursorColor = secGrey,
                            ),
                            textStyle = TextStyle(fontSize = 15.sp),
                            value = password_check.value,
                            singleLine = true,
                            onValueChange = {
                                password_check.value = it
                                password_check.value = it
                            },
                            modifier = Modifier
                                .width(270.dp),
                            leadingIcon = { Icon(imageVector = FeatherIcons.Lock, contentDescription = "Pass") },
                            trailingIcon = { IconButton(onClick = { showPassword_check = !showPassword_check }) {
                                Icon(imageVector = if (showPassword_check) FeatherIcons.EyeOff else FeatherIcons.Eye, contentDescription = "View") }
                            },
                            visualTransformation = if (showPassword_check) VisualTransformation.None else PasswordVisualTransformation(),
                            placeholder = { Text(text = stringResource(R.string.confirm_password),
                                fontFamily = nunitoRegular,
                                fontSize = 15.sp,
                                color = secGrey
                            ) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { focusManager.clearFocus() }),
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        OutlinedButton(
                            onClick = {  },
                            interactionSource = NoRippleInteractionSource(),
                            border = BorderStroke(1.dp, greenMain),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                        ) {
                            Text(text = stringResource(R.string.registration),
                                style = MaterialTheme.typography.h4.copy(
                                    color = greenMain,
                                    letterSpacing = 2.sp,
                                    fontSize = 22.sp,
                                    fontFamily = nunitoRegular))
                        }
                        Spacer(modifier = Modifier.padding(33.dp))
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
                                Image(
                                    ImageVector.vectorResource(id = R.drawable.gosuslugi_logo),
                                    contentDescription = "logo",
                                    modifier = Modifier
                                        .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://www.gosuslugi.ru/") }
                                        .size(40.dp))
                                Spacer(modifier = Modifier.padding(25.dp))
                                Image(
                                    ImageVector.vectorResource(id = R.drawable.vk_logo),
                                    contentDescription = "logo",
                                    modifier = Modifier
                                        .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://vk.com/artorius81") }
                                        .size(40.dp))
                                Spacer(modifier = Modifier.padding(25.dp))
                                Image(
                                    ImageVector.vectorResource(id = R.drawable.ok_logo),
                                    contentDescription = "logo",
                                    modifier = Modifier
                                        .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://ok.ru/") }
                                        .size(40.dp))
                            }
                        }
                    }
                }
                else {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier
                            .height(50.dp)) {
                            Image(
                                ImageVector.vectorResource(id = R.drawable.util_logo),
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
                                OutlinedButton(
                                    onClick = {
                                        onButtonSelected(Button.First)
                                        state.value = Button.First
                                        type.value = false
                                    },
                                    interactionSource = NoRippleInteractionSource(),
                                    border = if (state.value == Button.First) {
                                        BorderStroke(1.dp, greenMain)
                                    } else {
                                        BorderStroke(0.dp, white) },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                ) {
                                    Text(text = stringResource(R.string.login_type),
                                        style = MaterialTheme.typography.h4.copy(
                                            color = if (state.value == Button.First) {
                                                greenMain
                                            } else {
                                                black },
                                            letterSpacing = 2.sp,
                                            fontSize = 14.sp,
                                            fontFamily = nunitoBold))
                                }
                                Spacer(modifier = Modifier
                                    .padding(30.dp))
                                OutlinedButton(
                                    onClick = {
                                        onButtonSelected(Button.Second)
                                        state.value = Button.Second
                                        type.value = true
                                    },
                                    interactionSource = NoRippleInteractionSource(),
                                    border = if (state.value == Button.Second) {
                                        BorderStroke(1.dp, greenMain)
                                    } else {
                                        BorderStroke(0.dp, white) },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                ) {
                                    Text(text = stringResource(R.string.pass_type),
                                        style = MaterialTheme.typography.h4.copy(
                                            color = if (state.value == Button.Second) {
                                                greenMain
                                            } else {
                                                black },
                                            letterSpacing = 2.sp,
                                            fontSize = 14.sp,
                                            fontFamily = nunitoBold))
                                }
                            }
                            if (type.value) {
                                if (!OTP.value) {
                                    TogiCountryCodePicker(
                                        text = phoneNumber,
                                        onValueChange = { value ->
                                            if (value.length <= 15) {
                                                phoneNumber = value
                                            } },
                                        unfocusedBorderColor = white,
                                        modifier = Modifier
                                            .width(315.dp),
                                        focusedBorderColor = white,
                                        cursorColor = secGrey,
                                        bottomStyle = false, //  if true the text-field is below the country code selector at the top.
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    Spacer(modifier = Modifier.padding(41.dp))
                                    OutlinedButton(
                                        onClick = {
                                            if (phoneNumber.isEmpty()) { phoneError = true }
                                            if ((phoneNumber.length < 10) and (phoneNumber.isNotEmpty())) { phoNumbError = true }
                                            if (phoneNumber.length >= 10) { OTP.value = true; service.showNotification(OTPNumber.value)}
                                        },
                                        border = BorderStroke(1.dp, greenMain),
                                        interactionSource = NoRippleInteractionSource(),
                                        shape = RoundedCornerShape(8.dp),
                                        modifier = Modifier
                                    ) {
                                        Text(text = stringResource(R.string.next),
                                            style = MaterialTheme.typography.h4.copy(
                                                color = greenMain,
                                                letterSpacing = 2.sp,
                                                fontSize = 28.sp,
                                                fontFamily = nunitoBold))
                                    }
                                    TextButton(
                                        onClick = { registration.value = true },
                                        interactionSource = interactionSource,
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
                                            Image(
                                                ImageVector.vectorResource(id = R.drawable.gosuslugi_logo),
                                                contentDescription = "logo",
                                                modifier = Modifier
                                                    .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://www.gosuslugi.ru/") }
                                                    .size(40.dp))
                                            Spacer(modifier = Modifier.padding(25.dp))
                                            Image(
                                                ImageVector.vectorResource(id = R.drawable.vk_logo),
                                                contentDescription = "logo",
                                                modifier = Modifier
                                                    .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://vk.com/artorius81") }
                                                    .size(40.dp))
                                            Spacer(modifier = Modifier.padding(25.dp))
                                            Image(
                                                ImageVector.vectorResource(id = R.drawable.ok_logo),
                                                contentDescription = "logo",
                                                modifier = Modifier
                                                    .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://ok.ru/") }
                                                    .size(40.dp))
                                        }
                                    }
                                } else {
                                    Column(modifier = Modifier
                                        .height(50.dp)
                                        .fillMaxWidth()
                                        .padding(start = 50.dp)) {
                                        Text(text = stringResource(R.string.OTP),
                                            style = MaterialTheme.typography.h4.copy(
                                                color = black,
                                                letterSpacing = 2.sp,
                                                fontSize = 26.sp,
                                                fontFamily = nunitoBold))
                                        Text(text = stringResource(R.string.OTP_phone),
                                            style = MaterialTheme.typography.h4.copy(
                                                color = grey,
                                                letterSpacing = 2.sp,
                                                fontSize = 12.sp,
                                                fontFamily = nunitoRegular))
                                    }

                                    Spacer(modifier = Modifier.padding(15.dp))

                                    OtpTextField(
                                        otpText = otpValue,
                                        onOtpTextChange = { value, otpInputFilled ->
                                            otpValue = value
                                        }
                                    )
                                    Spacer(modifier = Modifier.padding(20.dp))
                                    OutlinedButton(
                                        onClick = {
                                            if (otpValue.isEmpty()) {
                                                OTPError = true
                                            } else if (OTPNumber.value == otpValue.toInt() || OTPNumber.value_again == otpValue.toInt()) {
                                                keyboardController?.hide()
                                                OnBoard.value = true
                                            }
                                            else { OTPError = true }
                                        },
                                        border = BorderStroke(1.dp, greenMain),
                                        interactionSource = NoRippleInteractionSource(),
                                        shape = RoundedCornerShape(8.dp),
                                        modifier = Modifier
                                    ) {
                                        Text(text = stringResource(R.string.log_in),
                                            style = MaterialTheme.typography.h4.copy(
                                                color = greenMain,
                                                letterSpacing = 2.sp,
                                                fontSize = 28.sp,
                                                fontFamily = nunitoBold))
                                    }
                                    TextButton(
                                        onClick = { service.showNotification(OTPNumber.value_again) },
                                        interactionSource = NoRippleInteractionSource(),
                                        modifier = Modifier
                                    ) {
                                        Text(text = stringResource(R.string.no_code),
                                            style = MaterialTheme.typography.h4.copy(
                                                color = greenMain,
                                                letterSpacing = 2.sp,
                                                fontSize = 14.sp,
                                                fontFamily = nunitoRegular))
                                    }
                                    TextButton(
                                        onClick = { registration.value = true },
                                        interactionSource = NoRippleInteractionSource(),
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
                                            Image(
                                                ImageVector.vectorResource(id = R.drawable.gosuslugi_logo),
                                                contentDescription = "logo",
                                                modifier = Modifier
                                                    .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://www.gosuslugi.ru/") }
                                                    .size(40.dp))
                                            Spacer(modifier = Modifier.padding(25.dp))
                                            Image(
                                                ImageVector.vectorResource(id = R.drawable.vk_logo),
                                                contentDescription = "logo",
                                                modifier = Modifier
                                                    .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://vk.com/artorius81") }
                                                    .size(40.dp))
                                            Spacer(modifier = Modifier.padding(25.dp))
                                            Image(
                                                ImageVector.vectorResource(id = R.drawable.ok_logo),
                                                contentDescription = "logo",
                                                modifier = Modifier
                                                    .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://ok.ru/") }
                                                    .size(40.dp))
                                        }
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
                                        color = secGrey
                                    ) },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Email,
                                        imeAction = ImeAction.Done
                                    ),
                                    keyboardActions = KeyboardActions(
                                        onDone = { focusManager.clearFocus() }),
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
                                        color = secGrey
                                    ) },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    ),
                                    keyboardActions = KeyboardActions(
                                        onDone = { focusManager.clearFocus() }),
                                )
                                Spacer(modifier = Modifier.padding(15.dp))
                                OutlinedButton(
                                    onClick = { if (login.value.text.isEmpty() and password.value.text.isNotEmpty()) { loginError = true }
                                        if (password.value.text.isEmpty() and login.value.text.isNotEmpty()) { passwordError = true }
                                        if (password.value.text.isEmpty() and login.value.text.isEmpty()) { logPassError = true }
                                        if (password.value.text.isNotEmpty() and login.value.text.isNotEmpty()) { OnBoard.value = true; keyboardController?.hide() }
                                    },
                                    border = BorderStroke(1.dp, greenMain),
                                    shape = RoundedCornerShape(8.dp),
                                    interactionSource = NoRippleInteractionSource(),
                                    modifier = Modifier
                                ) {
                                    Text(text = stringResource(R.string.log_in),
                                        style = MaterialTheme.typography.h4.copy(
                                            color = greenMain,
                                            letterSpacing = 2.sp,
                                            fontSize = 28.sp,
                                            fontFamily = nunitoBold))
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
                                    onClick = { registration.value = true },
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
                                        Image(
                                            ImageVector.vectorResource(id = R.drawable.gosuslugi_logo),
                                            contentDescription = "logo",
                                            modifier = Modifier
                                                .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://www.gosuslugi.ru/") }
                                                .size(40.dp))
                                        Spacer(modifier = Modifier.padding(25.dp))
                                        Image(
                                            ImageVector.vectorResource(id = R.drawable.vk_logo),
                                            contentDescription = "logo",
                                            modifier = Modifier
                                                .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://vk.com/artorius81") }
                                                .size(40.dp))
                                        Spacer(modifier = Modifier.padding(25.dp))
                                        Image(
                                            ImageVector.vectorResource(id = R.drawable.ok_logo),
                                            contentDescription = "logo",
                                            modifier = Modifier
                                                .clickable (indication = null, interactionSource = interactionSource) { uriHandler.openUri("https://ok.ru/") }
                                                .size(40.dp))
                                    }
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
    if (loginError) {
        loginError = false
        SweetError(message = "Введите логин", contentAlignment = Alignment.BottomCenter, padding = PaddingValues(bottom = 100.dp))
    }
    if (passwordError) {
        passwordError = false
        SweetError(message = "Введите пароль", contentAlignment = Alignment.BottomCenter, padding = PaddingValues(bottom = 100.dp))
    }
    if (logPassError) {
        logPassError = false
        SweetError(message = "Неверный логин или пароль", contentAlignment = Alignment.BottomCenter, padding = PaddingValues(bottom = 100.dp))
    }
    if (phoneError) {
        phoneError = false
        SweetError(message = "Введите номер телефона", contentAlignment = Alignment.BottomCenter, padding = PaddingValues(bottom = 100.dp))
    }
    if (phoNumbError) {
        phoNumbError = false
        SweetError(message = "Неверный номер телефона", contentAlignment = Alignment.BottomCenter, padding = PaddingValues(bottom = 100.dp))
    }
    if (OTPError) {
        OTPError = false
        SweetError(message = "Неверный СМС-код", contentAlignment = Alignment.BottomCenter, padding = PaddingValues(bottom = 100.dp))
    }
    AnimatedVisibility(visible = OnBoard.value,
        enter = scaleIn(
            animationSpec = tween(
                durationMillis = 50,
                easing = LinearEasing)
        )
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(white)) {
            OnboardingUi()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Buttons(service: NotificationService) {
    var selectedButton by remember { mutableStateOf(Button.First) }

    BottomSheet(service, selectedButton, onButtonSelected = { selectedButton = it })

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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtpTextField(modifier: Modifier = Modifier, otpText: String, otpCount: Int = 4, onOtpTextChange: (String, Boolean) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current
    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = {
            if (it.length <= otpCount) {
                onOtpTextChange.invoke(it, it.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(index: Int, text: String) {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val isFocused = text.length == index
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }
    Text(
        modifier = Modifier
            .width(50.dp)
            .border(
                2.dp, when {
                    isFocused -> greenMain
                    else -> grey
                }, RoundedCornerShape(14.dp)
            )
            .padding(2.dp),
        text = char,
        style = MaterialTheme.typography.h4.copy(
            color = grey,
            fontSize = 36.sp,
            fontFamily = nunitoBold),
        color = if (isFocused) {
            grey
        } else {
            grey
        },
        textAlign = TextAlign.Center
    )
}