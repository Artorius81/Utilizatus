package com.example.utilizatus.screens

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.utilizatus.R
import com.example.utilizatus.cards.CardMore
import com.example.utilizatus.cards.CardPopular
import com.example.utilizatus.cards.Item
import com.example.utilizatus.model.MapMarkerData
import com.example.utilizatus.ui.theme.*
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch
import java.security.cert.TrustAnchor

@SuppressLint("UnrememberedMutableState")
@Composable
fun Map() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

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
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

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
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
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
                            .height(80.dp)
                            .clickable { },
                        shape = roundedRectangleShape,
                        backgroundColor = item.color,
                    ) {
                        Column(
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
                            .height(100.dp)
                            .clickable {
                                showModalSheet.value = !showModalSheet.value
                                scope.launch {
                                    sheetState.show()
                                }; selectedCard = cardItem
                            },
                        shape = roundedRectangleShape,
                        backgroundColor = white
                    ) {
                        Column(
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
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        showModalSheet2.value = !showModalSheet2.value
                        scope2.launch {
                            sheetState2.show()
                        }; selectedCard2 = item
                    },
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
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

@Composable
fun Star() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    Text(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, top = 5.dp),
        text = stringResource(R.string.bonuses),
        style = MaterialTheme.typography.h4.copy(
            color = black,
            letterSpacing = 2.sp,
            fontSize = 32.sp,
            fontFamily = nunitoBold),
        textAlign = TextAlign.Start
    )
}

@Composable
fun Menu() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

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
}
