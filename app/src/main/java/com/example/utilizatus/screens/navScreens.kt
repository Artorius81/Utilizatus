package com.example.utilizatus.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.utilizatus.R
import com.example.utilizatus.cards.CardMore
import com.example.utilizatus.cards.CardPopular
import com.example.utilizatus.cards.Item
import com.example.utilizatus.ui.theme.*

@Composable
fun Home() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val roundedRectangleShape = RoundedCornerShape(12.dp)

    val viewModel: MyViewModel = viewModel()
    var selectedItemId by remember { mutableStateOf<Int?>(null) }
    val itemList = listOf(
        Item(0, "Перерабат.", R.drawable.recycl, recycle_icon_color),
        Item(1, "Бумага", R.drawable.paper_icon, leaf_icon_color),
        Item(2, "Стекло", R.drawable.glass_icon, beer_icon_color),
        Item(3, "Металл", R.drawable.metal_icon, metal_icon_color),
        Item(4, "Пластик", R.drawable.plastic_icon, plastic_icon_color),
        Item(5, "Орган. отходы", R.drawable.food_waste_icon, food_icon_color),
        Item(6, "Текстиль", R.drawable.textile, cloth_icon_color),
        Item(7, "Опас. отходы", R.drawable.dang, toxic_icon_color),
        Item(8, "Строит. отходы", R.drawable.const_icon, build_icon_color),
        Item(9, "Электроника", R.drawable.electro, electronics_icon_color),
        Item(10, "Неперерабат.", R.drawable.close_icon, close_icon_color)
    )

    val cardItems = listOf(
        CardMore(11, "Макулатура", R.drawable.paper, intArrayOf(0, 1)),
        CardMore(12, "Бутылки", R.drawable.bottles, intArrayOf(0, 2, 4)),
        CardMore(13, "Флаконы", R.drawable.vials, intArrayOf(0, 2, 4)),
        CardMore(14, "Метал. банки", R.drawable.metal_jar, intArrayOf(0, 3)),
        CardMore(15, "Ткань", R.drawable.cloth, intArrayOf(0, 6)),
        CardMore(16, "Стекло", R.drawable.glass, intArrayOf(0, 2)),
        CardMore(17, "Лекарства", R.drawable.medicine, intArrayOf(0, 7)),
        CardMore(18, "Техника", R.drawable.electr, intArrayOf(0, 3, 8, 9)),
        CardMore(19, "Мебель", R.drawable.furn, intArrayOf(0, 6)),
        CardMore(20, "Пищ. отходы", R.drawable.food_waste, intArrayOf(0, 5)),
        CardMore(21, "Батарейки", R.drawable.battery, intArrayOf(0, 7, 9))
    )

    val cardPop = listOf(
        CardPopular(22, "Газета", R.drawable.news, "Перерабатывается в качестве бумаги и картона"),
        CardPopular(23, "Журнал", R.drawable.magazine, "Нажмите, чтобы узнать подробнее"),
        CardPopular(24, "Пакет", R.drawable.bag, "Перерабатывается в качестве пластмассовых изделий"),
        CardPopular(25, "Пленка", R.drawable.wrap, "Может быть переработана в качестве сырья для производства пластиковых изделий"),
        CardPopular(26, "Одежда", R.drawable.clothes, "Перерабатывается в качестве изоляционного материала и прочих текстильных изделий"),
        CardPopular(27, "Телефон", R.drawable.phone, "Содержит множество ценных материалов, которые могут быть переработаны"),
        CardPopular(28, "Обувь", R.drawable.boots, "Может быть переработана в качестве сырья для производства резиновых изделий"),
        CardPopular(29, "Жестяные банки", R.drawable.tin, "Перерабатываются в качестве сырья для производства новых металлических изделий"),
        CardPopular(30, "Алюминевая фольга", R.drawable.foil, "Перерабатывается в качестве сырья для производства новых алюминиевых изделий"),
        CardPopular(31, "Лампа накаливания", R.drawable.lamp, "Содержит опасные химические элементы, которые должны быть утилизированы правильно"),
        CardPopular(32, "Краска", R.drawable.paint, "Содержит опасные химические вещества, которые должны быть утилизированы правильно"),
        CardPopular(33, "Бетон", R.drawable.concreate, "Может быть переработан в качестве заполнителя для новых строительных материалов"),
        CardPopular(34, "Масло", R.drawable.oil, "Может быть переработано в качестве топлива или сырья для производства новых смазочных материалов."),
        CardPopular(35, "Батарейка", R.drawable.batteri, "Должна быть утилизирована правильно, чтобы не вредить окружающей среде"),
        CardPopular(36, "Еда", R.drawable.food, "Может быть переработана в качестве компоста или использована для производства биотоплива"),
        CardPopular(37, "Коробка", R.drawable.box, "Может быть переработана в качестве заполнителя для новых упаковочных материалов"),
        CardPopular(38, "Постельное бельё", R.drawable.bedding, "Может быть переработано в изоляцию"),
        CardPopular(39, "Дерево", R.drawable.wood, "Превращается в древесный уголь")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                text = "Главная",
                style = MaterialTheme.typography.h4.copy(
                    color = black,
                    letterSpacing = 2.sp,
                    fontSize = 32.sp,
                    fontFamily = nunitoBold
                ),
            )
            LazyRow(modifier = Modifier) {
                items(itemList) { item ->
                    var selectedItemId = viewModel.selectedItemId.value
                    val isSelected = selectedItemId == item.id
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                            .height(80.dp)
                            .clickable {
                                selectedItemId = if (selectedItemId == item.id) {
                                    null
                                } else {
                                    item.id
                                }
                            },
                        shape = roundedRectangleShape,
                        elevation = 4.dp,
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
                text = "Подробнее",
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
                            .clickable { },
                        shape = roundedRectangleShape,
                        elevation = 4.dp,
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
                text = "Популярное",
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
                    .clickable {  },
                elevation = 4.dp
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
}

@Composable
fun Map() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    Text(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, top = 5.dp),
        text = "Карта",
        style = MaterialTheme.typography.h4.copy(
            color = black,
            letterSpacing = 2.sp,
            fontSize = 32.sp,
            fontFamily = nunitoBold),
        textAlign = TextAlign.Start
    )
}

@Composable
fun Star() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    Text(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, top = 5.dp),
        text = "Мои бонусы",
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

    Text(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, top = 5.dp),
        text = "Меню",
        style = MaterialTheme.typography.h4.copy(
            color = black,
            letterSpacing = 2.sp,
            fontSize = 32.sp,
            fontFamily = nunitoBold),
        textAlign = TextAlign.Start
    )
}

class MyViewModel : ViewModel() {
    private val _selectedItemId = MutableLiveData<Int?>(null)
    val selectedItemId: LiveData<Int?> = _selectedItemId

    fun selectItem(itemId: Int?) {
        _selectedItemId.value = itemId
    }
}
