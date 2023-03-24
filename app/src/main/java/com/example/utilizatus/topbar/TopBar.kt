package com.example.utilizatus.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utilizatus.R
import com.example.utilizatus.ui.theme.greenMain
import com.example.utilizatus.ui.theme.white
import compose.icons.FeatherIcons
import compose.icons.feathericons.Search

@Composable
fun TopBar() {
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    TopAppBar(
        backgroundColor = white,
        modifier = Modifier.padding(top = 15.dp),
        elevation = 0.dp,
        actions = { IconButton(onClick = { /*TODO*/ }) {
            Icon(FeatherIcons.Search, contentDescription = "Search")
        }},
        title = { Image(
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
    )
}