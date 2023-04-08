package com.example.utilizatus.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.utilizatus.MainActivity
import com.example.utilizatus.R
import com.example.utilizatus.cards.CardMore
import com.example.utilizatus.cards.CardPopular
import com.example.utilizatus.cards.Item
import com.example.utilizatus.model.MapMarkerData
import com.example.utilizatus.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import compose.icons.FeatherIcons
import compose.icons.feathericons.Eye
import compose.icons.feathericons.EyeOff
import compose.icons.feathericons.User
import kotlinx.coroutines.launch
import java.util.*

@SuppressLint("UnrememberedMutableState")
@Composable
fun Map() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))

// Set properties using MapProperties which you can use to recompose the map
    val mapProperties by remember {
        mutableStateOf(
            MapProperties(maxZoomPreference = 500f, minZoomPreference = 10f, mapType = MapType.HYBRID)
        )
    }

    val markerList = listOf(
        MapMarkerData(1, "Утилизация отходов: просп. Острякова, 44Б", LatLng(43.138642, 131.904132)),
        MapMarkerData(2, "Пункт приёма батареек: ул. Бестужева, 23", LatLng(43.110439, 131.876726)),
        MapMarkerData(3, "Скупка вторсырья: ул. Краева, 8А", LatLng(43.104957, 131.896902)),
        MapMarkerData(4, "Точка сбора мусора: Народный просп. 6", LatLng(43.128360, 131.921786)),
        MapMarkerData(5, "Утилизация отходов: Бархатная ул. 3", LatLng(43.073411, 131.939548)),
        MapMarkerData(6, "Скупка вторсырья: Снеговая ул. 6А", LatLng(43.139173, 131.933132)),
        MapMarkerData(7, "Пункт приёма вторсырья: Бородинская ул. 30Б", LatLng(43.164894, 131.940889)),
        MapMarkerData(8, "Утилизация отходов: ул. Фанзавод, 1", LatLng(43.242909, 132.014850)),
        MapMarkerData(9, "Приём ртутьсодержащих отходов: посёлок Трудовое", LatLng(43.300378, 132.063063)),
    )

    val mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(mapToolbarEnabled = true)
        )
    }
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(markerList[0].latLng, 11f)
    }
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = mapProperties,
            uiSettings = mapUiSettings,
            cameraPositionState = cameraPositionState
        ) {
            markerList.forEach { typeOf ->
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
            MapMarker(
                position = typeOf.latLng,
                title = typeOf.title,
                context = LocalContext.current,
                iconResourceId = R.drawable.recycle_machine
            )
        }
        }
        Text(modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 5.dp),
            text = stringResource(R.string.map),
            style = MaterialTheme.typography.h4.copy(
                color = white,
                letterSpacing = 2.sp,
                fontSize = 32.sp,
                fontFamily = nunitoBold),
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun MapMarker(
    context: Context,
    position: LatLng,
    title: String,
    @DrawableRes iconResourceId: Int
) {
    val icon = bitmapDescriptorFromVector(
        context, iconResourceId
    )
    Marker(
        state = MarkerState(position = position),
        title = title,
        icon = icon,
    )
}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}

@Composable
fun BottomSheetContentPop(item: CardPopular) {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))

    Surface(
        modifier = Modifier.height(450.dp)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(white)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(modifier = Modifier
                    .padding(8.dp)
                    .width(120.dp)
                    .height(100.dp),
                    shape = RoundedCornerShape(16.dp))
                {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = "description",
                            tint = black,
                            modifier = Modifier.size(60.dp)
                        )
                        Text(
                            text = item.name,
                            style = MaterialTheme.typography.h4.copy(
                                color = black,
                                fontSize = 14.sp,
                                fontFamily = nunitoBold
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
                Text(
                    text = stringResource(R.string.descript),
                    style = MaterialTheme.typography.h4.copy(
                        color = black,
                        fontSize = 16.sp,
                        fontFamily = nunitoBold
                    ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 4.dp, start = 5.dp)
                )
                Card(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentSize(),
                    shape = RoundedCornerShape(16.dp))
                {
                    Text(
                        text = item.desc,
                        style = MaterialTheme.typography.h6.copy(
                            color = black,
                            fontSize = 16.sp,
                            fontFamily = nunitoMedium
                        ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(top = 5.dp, start = 5.dp, end = 5.dp, bottom = 5.dp),
                    )
                }
            }
        }
    }
}


@Composable
fun BottomSheetContent(cardItem: CardMore, itemList: List<Item>) {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val backColor = mutableListOf<Color>()
    cardItem.type.forEach { typeCol ->
        val typeColor = itemList.find { it.id == typeCol }
        if (typeColor != null) {
            backColor.add(typeColor.color)
        }
    }
    val brush = Brush.linearGradient(
        colors = backColor,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Surface(
        modifier = Modifier.height(450.dp)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(brush)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(modifier = Modifier
                    .padding(8.dp)
                    .width(120.dp)
                    .height(100.dp),
                    shape = RoundedCornerShape(16.dp))
                {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = cardItem.icon),
                            contentDescription = "description",
                            tint = black,
                            modifier = Modifier.size(60.dp)
                        )
                        Text(
                            text = cardItem.name,
                            style = MaterialTheme.typography.h4.copy(
                                color = black,
                                fontSize = 14.sp,
                                fontFamily = nunitoBold
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.End
                        ) {
                            cardItem.type.forEach { typeId ->
                                val typeItem = itemList.find { it.id == typeId }
                                if (typeItem != null) {
                                    Icon(
                                        painter = painterResource(id = typeItem.icon),
                                        contentDescription = typeItem.name,
                                        tint = typeItem.color,
                                        modifier = Modifier
                                            .size(25.dp)
                                            .padding(4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                Text(
                    text = stringResource(R.string.descript),
                    style = MaterialTheme.typography.h4.copy(
                        color = white,
                        fontSize = 16.sp,
                        fontFamily = nunitoBold
                    ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 4.dp, start = 5.dp)
                )
                Card(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentSize(),
                    shape = RoundedCornerShape(16.dp))
                {
                    Text(
                        text = cardItem.description,
                        style = MaterialTheme.typography.h6.copy(
                            color = black,
                            fontSize = 16.sp,
                            fontFamily = nunitoMedium
                        ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(top = 5.dp, start = 5.dp, end = 5.dp, bottom = 5.dp),
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun Home() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val roundedRectangleShape = RoundedCornerShape(12.dp)

    val itemList = listOf(
        Item(0, stringResource(R.string.item_1), R.drawable.recycl, recycle_icon_color),
        Item(1, stringResource(R.string.item_2), R.drawable.paper_icon, leaf_icon_color),
        Item(2, stringResource(R.string.item_3), R.drawable.glass_icon, beer_icon_color),
        Item(3, stringResource(R.string.item_4), R.drawable.metal_icon, metal_icon_color),
        Item(4, stringResource(R.string.item_5), R.drawable.plastic_icon, plastic_icon_color),
        Item(5, stringResource(R.string.item_6), R.drawable.food_waste_icon, food_icon_color),
        Item(6, stringResource(R.string.item_7), R.drawable.textile, cloth_icon_color),
        Item(7, stringResource(R.string.item_8), R.drawable.dang, toxic_icon_color),
        Item(8, stringResource(R.string.item_9), R.drawable.const_icon, build_icon_color),
        Item(9, stringResource(R.string.item_10), R.drawable.electro, electronics_icon_color),
        Item(10, stringResource(R.string.item_11), R.drawable.close_icon, close_icon_color)
    )

    val cardItems = listOf(
        CardMore(11, stringResource(R.string.card_more_1), R.drawable.paper, stringResource(R.string.desc_1), intArrayOf(0, 1)),
        CardMore(12, stringResource(R.string.card_more_2), R.drawable.bottles, stringResource(R.string.desc_2), intArrayOf(0, 2, 4)),
        CardMore(13, stringResource(R.string.card_more_3), R.drawable.vials, stringResource(R.string.desc_3), intArrayOf(0, 2, 4)),
        CardMore(14, stringResource(R.string.card_more_4), R.drawable.metal_jar, stringResource(R.string.desc_4), intArrayOf(0, 3)),
        CardMore(15, stringResource(R.string.card_more_5), R.drawable.cloth, stringResource(R.string.desc_5), intArrayOf(0, 6)),
        CardMore(16, stringResource(R.string.card_more_6), R.drawable.glass, stringResource(R.string.desc_6), intArrayOf(0, 2)),
        CardMore(17, stringResource(R.string.card_more_7), R.drawable.medicine, stringResource(R.string.desc_7), intArrayOf(0, 7)),
        CardMore(18, stringResource(R.string.card_more_8), R.drawable.electr, stringResource(R.string.desc_8), intArrayOf(0, 3, 8, 9)),
        CardMore(19, stringResource(R.string.card_more_9), R.drawable.furn, stringResource(R.string.desc_9), intArrayOf(0, 6)),
        CardMore(20, stringResource(R.string.card_more_10), R.drawable.food_waste, stringResource(R.string.desc_10), intArrayOf(0, 5)),
        CardMore(21, stringResource(R.string.card_more_11), R.drawable.battery, stringResource(R.string.desc_11), intArrayOf(0, 7, 9))
    )

    val cardPop = listOf(
        CardPopular(22, stringResource(R.string.card_pop_1), R.drawable.news, stringResource(R.string.card_pop_desc)),
        CardPopular(23, stringResource(R.string.card_pop_2), R.drawable.magazine, stringResource(R.string.card_pop_desc)),
        CardPopular(24, stringResource(R.string.card_pop_3), R.drawable.bag, stringResource(R.string.card_pop_desc)),
        CardPopular(25, stringResource(R.string.card_pop_4), R.drawable.wrap, stringResource(R.string.card_pop_desc)),
        CardPopular(26, stringResource(R.string.card_pop_5), R.drawable.clothes, stringResource(R.string.card_pop_desc)),
        CardPopular(27, stringResource(R.string.card_pop_6), R.drawable.phone, stringResource(R.string.card_pop_desc)),
        CardPopular(28, stringResource(R.string.card_pop_7), R.drawable.boots, stringResource(R.string.card_pop_desc)),
        CardPopular(29, stringResource(R.string.card_pop_8), R.drawable.tin, stringResource(R.string.card_pop_desc)),
        CardPopular(30, stringResource(R.string.card_pop_9), R.drawable.foil, stringResource(R.string.card_pop_desc)),
        CardPopular(31, stringResource(R.string.card_pop_10), R.drawable.lamp, stringResource(R.string.card_pop_desc)),
        CardPopular(32, stringResource(R.string.card_pop_11), R.drawable.paint, stringResource(R.string.card_pop_desc)),
        CardPopular(33, stringResource(R.string.card_pop_12), R.drawable.concreate, stringResource(R.string.card_pop_desc)),
        CardPopular(34, stringResource(R.string.card_pop_13), R.drawable.oil, stringResource(R.string.card_pop_desc)),
        CardPopular(35, stringResource(R.string.card_pop_14), R.drawable.batteri, stringResource(R.string.card_pop_desc)),
        CardPopular(36, stringResource(R.string.card_pop_15), R.drawable.food, stringResource(R.string.card_pop_desc)),
        CardPopular(37, stringResource(R.string.card_pop_16), R.drawable.box, stringResource(R.string.card_pop_desc)),
        CardPopular(38, stringResource(R.string.card_pop_17), R.drawable.bedding, stringResource(R.string.card_pop_desc)),
        CardPopular(39, stringResource(R.string.card_pop_18), R.drawable.wood, stringResource(R.string.card_pop_desc))
    )

    var selectedCard by remember { mutableStateOf<CardMore?>(null) }
    var selectedCard2 by remember { mutableStateOf<CardPopular?>(null) }

    val showModalSheet = rememberSaveable {
        mutableStateOf(false)
    }
    val showModalSheet2 = rememberSaveable {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()
    val scope2 = rememberCoroutineScope()

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )
    val sheetState2 = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                text = stringResource(R.string.main),
                style = MaterialTheme.typography.h4.copy(
                    color = black,
                    letterSpacing = 2.sp,
                    fontSize = 32.sp,
                    fontFamily = nunitoBold
                ),
            )
            LazyRow(modifier = Modifier) {
                items(itemList) { item ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                            .height(80.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = item.color,
                    ) {
                        Column(
                            modifier = Modifier.clickable {  },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = "Favorite icon",
                                tint = white,
                                modifier = Modifier.size(35.dp)
                            )
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.h4.copy(
                                    color = white,
                                    fontSize = 12.sp,
                                    fontFamily = nunitoBold
                                ),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 0.dp)
                            )
                        }
                    }
                }
            }
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = stringResource(R.string.more),
                style = MaterialTheme.typography.h4.copy(
                    color = black,
                    letterSpacing = 2.sp,
                    fontSize = 24.sp,
                    fontFamily = nunitoBold
                ),
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .padding(start = 20.dp)
                    .height(2.dp)
                    .background(greenMain)
            ) {
                Divider()
            }
            LazyRow(modifier = Modifier) {
                items(cardItems) { cardItem ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(120.dp)
                            .height(100.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white
                    ) {
                        Column(
                            modifier = Modifier.clickable {
                                showModalSheet.value = !showModalSheet.value
                                scope.launch {
                                    sheetState.show()
                                }; selectedCard = cardItem
                            },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = cardItem.icon),
                                contentDescription = "Favorite icon",
                                tint = black,
                                modifier = Modifier.size(45.dp)
                            )
                            Text(
                                text = cardItem.name,
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoBold
                                ),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Column(
                                Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.End
                            ) {
                                cardItem.type.forEach { typeId ->
                                    val typeItem = itemList.find { it.id == typeId }
                                    if (typeItem != null) {
                                        Icon(
                                            painter = painterResource(id = typeItem.icon),
                                            contentDescription = typeItem.name,
                                            tint = typeItem.color,
                                            modifier = Modifier
                                                .size(25.dp)
                                                .padding(4.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = stringResource(R.string.popular),
                style = MaterialTheme.typography.h4.copy(
                    color = black,
                    letterSpacing = 2.sp,
                    fontSize = 24.sp,
                    fontFamily = nunitoBold
                ),
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .padding(start = 20.dp)
                    .height(2.dp)
                    .background(greenMain)
            ) {
                Divider()
            }
        }
        items(cardPop) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            ) {
                Row(modifier = Modifier.clickable {
                    showModalSheet2.value = !showModalSheet2.value
                    scope2.launch {
                        sheetState2.show()
                    }; selectedCard2 = item
                }, verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(72.dp)
                            .padding(8.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 16.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item.name,
                            style = MaterialTheme.typography.h4.copy(
                                color = black,
                                letterSpacing = 2.sp,
                                fontSize = 16.sp,
                                fontFamily = nunitoBold
                            ))
                        Text(text = item.desc,
                            style = MaterialTheme.typography.h4.copy(
                                color = black,
                                letterSpacing = 0.sp,
                                fontSize = 10.sp,
                                fontFamily = nunitoRegular
                            ))
                    }
                }
            }
        }
    }

    if ((selectedCard != null)) {
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetContent = { BottomSheetContent(cardItem = selectedCard!!, itemList = itemList) },
            scrimColor = Color.Unspecified,
        ) {
        }
    }
    if ((selectedCard2 != null)) {
        ModalBottomSheetLayout(
            sheetState = sheetState2,
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetContent = { BottomSheetContentPop(item = selectedCard2!!) },
            scrimColor = Color.Unspecified,
        ) {
        }
    }
}

data class Task(
    val name: String,
    val description: String,
    val ecoPoints: Int
)

@Composable
fun Star() {
    val tasks = listOf(
        Task(
            name = "Voluntary Saturdays",
            description = "Spend a Saturday volunteering for an environmental organization or event.",
            ecoPoints = 50
        ),
        Task(
            name = "Plastic-Free Week",
            description = "Avoid using single-use plastics for a whole week.",
            ecoPoints = 100
        ),
        Task(
            name = "Charity Donation",
            description = "Donate to a charity that supports environmental causes.",
            ecoPoints = 150
        ),
        Task(
            name = "Eco-Friendly Cleaning",
            description = "Switch to eco-friendly cleaning products for a month.",
            ecoPoints = 200
        ),
        Task(
            name = "Public Transport",
            description = "Take public transport instead of driving for a whole week.",
            ecoPoints = 75
        ),
        Task(
            name = "Bike to Work",
            description = "Bike to work instead of driving for a week.",
            ecoPoints = 75
        ),
        Task(
            name = "Beach Cleanup",
            description = "Organize or participate in a beach cleanup event.",
            ecoPoints = 100
        ),
        Task(
            name = "Plant a Tree",
            description = "Plant a tree in your community.",
            ecoPoints = 50
        )
    )


    var availableTasks by remember { mutableStateOf(tasks) }
    var activeTasks by remember { mutableStateOf(listOf<Task>()) }
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))

    LazyColumn() {
        item{
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                    text = stringResource(R.string.tasks),
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black,
                        letterSpacing = 2.sp,
                        fontSize = 32.sp,
                        fontFamily = nunitoBold
                    ),
                    textAlign = TextAlign.Start
                )

                // Slider to display available tasks
                LazyRow(
                    contentPadding = PaddingValues(start = 20.dp, top = 20.dp, end = 20.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(availableTasks) { task ->
                        TaskCard(task = task, activeTasks = activeTasks, onStartClicked = {
                            if (activeTasks.size < 3 && task !in activeTasks) {
                                activeTasks = activeTasks + task
                                availableTasks = availableTasks.filter { it != task }
                            }
                        })
                    }
                }

                // Slider to display active tasks
                if (activeTasks.isNotEmpty()) {
                    Text(
                        modifier = Modifier.padding(start = 20.dp, top = 30.dp),
                        text = "Начато",
                        style = MaterialTheme.typography.h4.copy(
                            color = Color.Black,
                            letterSpacing = 2.sp,
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        ),
                        textAlign = TextAlign.Start
                    )

                    LazyRow(
                        contentPadding = PaddingValues(start = 20.dp, top = 20.dp, end = 20.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(activeTasks) { task ->
                            ActiveTaskCard(task = task, onCancelClicked = {
                                activeTasks = activeTasks.filter { it != task }
                                activeTasks = activeTasks - task
                                availableTasks = availableTasks + task
                            })
                        }
                    }
                }
                PartnerInfo()
            }
        }
    }
}

@Composable
fun TaskCard(task: Task, onStartClicked: (Task) -> Unit, activeTasks: List<Task>) {
    var started by remember { mutableStateOf(false) }
    val dialogShownState = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(end = 16.dp)
            .clickable(
                onClick = {
                    if (!started) {
                        if (activeTasks.size < 3) {
                            started = true
                            onStartClicked(task)
                        } else {
                            dialogShownState.value = true
                        }
                    }
                }
            )
            .size(200.dp, 250.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = task.name,
                style = MaterialTheme.typography.h6,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = task.description,
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Eco Points",
                    tint = Color(0xFF3DB88B),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = task.ecoPoints.toString(),
                    style = MaterialTheme.typography.body2,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        if (activeTasks.size < 3) {
                            started = true
                            onStartClicked(task)
                        } else {
                            dialogShownState.value = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Start",
                        style = MaterialTheme.typography.button
                    )
                }
            }
            if (dialogShownState.value) {
                AlertDialog(
                    onDismissRequest = { dialogShownState.value = false },
                    title = { Text(text = "Limit Reached") },
                    text = { Text(text = "You can only start up to 3 tasks at once.") },
                    confirmButton = {
                        Button(
                            onClick = { dialogShownState.value = false },
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                        ) {
                            Text(text = "OK")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ActiveTaskCard(task: Task, onCancelClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(end = 16.dp)
            .size(200.dp, 250.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = task.name,
                style = MaterialTheme.typography.h6,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = task.description,
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Eco Points",
                    tint = Color(0xFF3DB88B),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = task.ecoPoints.toString(),
                    style = MaterialTheme.typography.body2,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        onCancelClicked()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Delete",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}

@Composable
fun PartnerInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Our Partners",
            style = MaterialTheme.typography.h6,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Exchange your eco-points for discounts in our partner stores!",
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.recycle_machine),
                contentDescription = "Store 1",
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.recycle_machine),
                contentDescription = "Store 2",
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.recycle_machine),
                contentDescription = "Store 3",
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Menu(navController: NavHostController) {
    val roundedRectangleShape = RoundedCornerShape(12.dp)
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Column {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, top = 5.dp),
                    text = stringResource(R.string.menu),
                    style = MaterialTheme.typography.h4.copy(
                        color = black,
                        letterSpacing = 2.sp,
                        fontSize = 32.sp,
                        fontFamily = nunitoBold
                    ),
                    textAlign = TextAlign.Start
                )
                Card(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(80.dp),
                    shape = roundedRectangleShape,
                    backgroundColor = white,
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("PROFILE") }, horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(72.dp)
                                .padding(8.dp)
                        )
                        Column(modifier = Modifier
                            .width(200.dp)
                            .height(80.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start) {
                            Text(modifier = Modifier,
                                text = stringResource(R.string.username),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 16.sp,
                                    fontFamily = nunitoBold
                                ),
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.edit_profile),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 10.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.edit_profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                                .padding(8.dp, end = 10.dp)
                        )
                    }
                }
                // Система part
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                    text = stringResource(R.string.system),
                    style = MaterialTheme.typography.h4.copy(
                        color = black,
                        letterSpacing = 2.sp,
                        fontSize = 24.sp,
                        fontFamily = nunitoBold
                    ),
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .padding(start = 20.dp)
                        .height(2.dp)
                        .background(greenMain)
                ) {
                    Divider()
                }
                Column {
                    Card(modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.dark_mode),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(54.dp)
                                    .padding(8.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.dark_mode),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp))
                    Card(modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(8.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.location),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                }
                // Уведомления part
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                    text = stringResource(R.string.notifications),
                    style = MaterialTheme.typography.h4.copy(
                        color = black,
                        letterSpacing = 2.sp,
                        fontSize = 24.sp,
                        fontFamily = nunitoBold
                    ),
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .padding(start = 20.dp)
                        .height(2.dp)
                        .background(greenMain)
                ) {
                    Divider()
                }
                Column {
                    Card(modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.notif),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(8.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.notifications_on),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp))
                    Card(modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.update),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(8.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.auto_update),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp))
                    Card(modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.tasks),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(8.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.receive_tasks),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                }
                // Прочее part
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                    text = stringResource(R.string.other),
                    style = MaterialTheme.typography.h4.copy(
                        color = black,
                        letterSpacing = 2.sp,
                        fontSize = 24.sp,
                        fontFamily = nunitoBold
                    ),
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .padding(start = 20.dp)
                        .height(2.dp)
                        .background(greenMain)
                ) {
                    Divider()
                }
                Column {
                    Card(modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.vk_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(8.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.vk),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp))
                    Card(modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.gosuslugi_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(8.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.gos),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp))
                    Card(modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ok_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(42.dp)
                                    .padding(start = 13.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = stringResource(R.string.ok),
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                CustomSwitch(width = 50.dp,
                                    height = 30.dp,
                                    checkedTrackColor = greenMain,
                                    uncheckedTrackColor = grey_black,
                                    borderWidth = 2.dp,
                                    thumbSize = 6.dp)
                            }
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp))
                    Card(modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        shape = roundedRectangleShape,
                        backgroundColor = white) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ok_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(42.dp)
                                    .padding(start = 13.dp, end = 10.dp)
                            )
                            Text(modifier = Modifier,
                                text = "Часто задаваемые вопросы",
                                style = MaterialTheme.typography.h4.copy(
                                    color = black,
                                    fontSize = 14.sp,
                                    fontFamily = nunitoRegular
                                ),
                            )
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End) {
                                Image(
                                    painter = painterResource(id = R.drawable.edit_arrow),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(48.dp)
                                        .padding(8.dp, end = 10.dp),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )
                            }
                        }
                    }
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(modifier = Modifier,
                    text = "v1.0",
                    style = MaterialTheme.typography.h4.copy(
                        color = grey,
                        fontSize = 14.sp,
                        fontFamily = nunitoRegular
                    ),
                )
            }
            Card(modifier = Modifier
                .padding(top = 10.dp, start = 50.dp, end = 50.dp, bottom = 10.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 8.dp,
                    spotColor = Color.Red,
                    ambientColor = Color.Red,
                    shape = roundedRectangleShape
                )
                .height(50.dp),
                shape = roundedRectangleShape,
                backgroundColor = white) {
                val mContext = LocalContext.current
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        mContext.startActivity(
                            Intent(
                                mContext,
                                MainActivity::class.java
                            )
                        )
                    }, horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.log_out),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(8.dp, end = 10.dp),
                        colorFilter = ColorFilter.tint(Color.Red)
                    )
                    Text(modifier = Modifier,
                        text = stringResource(R.string.log_out),
                        style = MaterialTheme.typography.h4.copy(
                            color = Color.Red,
                            fontSize = 14.sp,
                            fontFamily = nunitoRegular
                        ),
                    )
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End) {
                        Image(
                            painter = painterResource(id = R.drawable.sad_face),
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                                .padding(8.dp, end = 10.dp),
                            colorFilter = ColorFilter.tint(Color.Red)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Profile(navController: NavHostController) {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val profile_name = remember { mutableStateOf(TextFieldValue()) }
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    LazyColumn() {
        item {
            Icon(
                painter = painterResource(R.drawable.go_back),
                contentDescription = null,
                modifier = Modifier
                    .size(52.dp)
                    .padding(top = 15.dp, start = 20.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        navController.navigate("MENU")
                    }
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)) {
                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(124.dp)
                            .padding(8.dp)
                            .shadow(
                                elevation = 36.dp,
                                spotColor = Color.Green,
                                ambientColor = Color.Green,
                                shape = CircleShape
                            )
                    )
                    Text(modifier = Modifier,
                        text = stringResource(R.string.username),
                        style = MaterialTheme.typography.h4.copy(
                            color = black,
                            fontSize = 24.sp,
                            fontFamily = nunitoBold
                        ),
                    )
                    Text(modifier = Modifier,
                        text = "Владивосток",
                        style = MaterialTheme.typography.h4.copy(
                            color = black,
                            fontSize = 18.sp,
                            fontFamily = nunitoRegular
                        ),
                    )
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier
                                .size(22.dp)
                        )
                        Text(modifier = Modifier,
                            text = "12074",
                            style = MaterialTheme.typography.h4.copy(
                                color = black,
                                fontSize = 16.sp,
                                fontFamily = nunitoRegular
                            ),
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start) {
                Text(text = "Имя", modifier = Modifier)
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = white,
                        textColor = greenMain,
                        cursorColor = secGrey,
                    ),
                    textStyle = TextStyle(fontSize = 15.sp),
                    value = profile_name.value,
                    singleLine = true,
                    onValueChange = {
                        profile_name.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text(text = "Данил",
                        fontFamily = nunitoBold,
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
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Фамилия", modifier = Modifier)
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = white,
                        textColor = greenMain,
                        cursorColor = secGrey,
                    ),
                    textStyle = TextStyle(fontSize = 15.sp),
                    value = profile_name.value,
                    singleLine = true,
                    onValueChange = {
                        profile_name.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text(text = "Басов",
                        fontFamily = nunitoBold,
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
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Номер телефона", modifier = Modifier)
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = white,
                        textColor = greenMain,
                        cursorColor = secGrey,
                    ),
                    textStyle = TextStyle(fontSize = 15.sp),
                    value = profile_name.value,
                    singleLine = true,
                    onValueChange = {
                        profile_name.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text(text = "+7-924-436-35-33",
                        fontFamily = nunitoBold,
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
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Город", modifier = Modifier)
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = white,
                        textColor = greenMain,
                        cursorColor = secGrey,
                    ),
                    textStyle = TextStyle(fontSize = 15.sp),
                    value = profile_name.value,
                    singleLine = true,
                    onValueChange = {
                        profile_name.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    trailingIcon = { Icon(imageVector = FeatherIcons.User, contentDescription = "Lock Icon") },
                    placeholder = { Text(text = "Владивосток",
                        fontFamily = nunitoBold,
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
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "E-mail", modifier = Modifier)
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = white,
                        textColor = greenMain,
                        cursorColor = secGrey,
                    ),
                    textStyle = TextStyle(fontSize = 15.sp),
                    value = profile_name.value,
                    singleLine = true,
                    onValueChange = {
                        profile_name.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text(text = "Artorius.81@yandex.ru",
                        fontFamily = nunitoBold,
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
            }
        }
    }
}

@Composable
fun CustomSwitch(
    width: Dp = 72.dp,
    height: Dp = 40.dp,
    checkedTrackColor: Color = Color(0xFF35898F),
    uncheckedTrackColor: Color = Color(0xFFe0e0e0),
    gapBetweenThumbAndTrackEdge: Dp = 8.dp,
    borderWidth: Dp = 4.dp,
    cornerSize: Int = 50,
    iconInnerPadding: Dp = 4.dp,
    thumbSize: Dp = 24.dp,
) {

    // this is to disable the ripple effect
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // state of the switch
    var switchOn by remember {
        mutableStateOf(false)
    }

    // for moving the thumb
    val alignment by animateAlignmentAsState(if (switchOn) 1f else -1f)

    // outer rectangle with border
    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .border(
                width = borderWidth,
                color = if (switchOn) checkedTrackColor else uncheckedTrackColor,
                shape = RoundedCornerShape(percent = cornerSize)
            )
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                switchOn = !switchOn
            },
        contentAlignment = Alignment.Center
    ) {

        // this is to add padding at the each horizontal side
        Box(
            modifier = Modifier
                .padding(
                    start = gapBetweenThumbAndTrackEdge,
                    end = gapBetweenThumbAndTrackEdge
                )
                .fillMaxSize(),
            contentAlignment = alignment
        ) {

            // thumb with icon
            Icon(
                imageVector = if (switchOn) Icons.Filled.Done else Icons.Filled.Close,
                contentDescription = if (switchOn) "Enabled" else "Disabled",
                modifier = Modifier
                    .size(size = thumbSize)
                    .background(
                        color = if (switchOn) checkedTrackColor else uncheckedTrackColor,
                        shape = CircleShape
                    )
                    .padding(all = iconInnerPadding),
                tint = Color.White
            )
        }
    }
}

@Composable
private fun animateAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment> {
    val bias by animateFloatAsState(targetBiasValue)
    return derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) }
}
