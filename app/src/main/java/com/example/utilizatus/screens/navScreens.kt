package com.example.utilizatus.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.utilizatus.cards.Item
import com.example.utilizatus.cards.Card
import com.example.utilizatus.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home() {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val roundedRectangleShape = RoundedCornerShape(12.dp)

    val viewModel: MyViewModel = viewModel()
    var selectedItemId by remember { mutableStateOf<Int?>(null) }
    val itemList = listOf(
        Item(0, "Перерабат.", R.drawable.recycle_icon, recycle_icon_color),
        Item(1, "Бумага", R.drawable.leaf_icon, leaf_icon_color),
        Item(2, "Стекло", R.drawable.beer_bottle_icon, beer_icon_color),
        Item(3, "Металл", R.drawable.metal_icon, metal_icon_color),
        Item(4, "Пластик", R.drawable.plastic_icon, plastic_icon_color),
        Item(5, "Опасный мусор", R.drawable.toxic_icon, toxic_icon_color),
        Item(6, "Электроника", R.drawable.electronics_icon, electronics_icon_color),
        Item(7, "Неперерабат.", R.drawable.close_icon, close_icon_color)
    )

    val cardItems = listOf(
        Card(8, "Макулатура", R.drawable.beer_bottle_icon),
        Card(9, "Бутылка", R.drawable.beer_bottle_icon),
        Card(10, "Текстиль", R.drawable.beer_bottle_icon),
        Card(11, "Стекло", R.drawable.beer_bottle_icon),
        Card(12, "Техника", R.drawable.beer_bottle_icon)
    )

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
    LazyRow(modifier = Modifier.padding(top = 60.dp)) {
        items(itemList) { item ->
            var selectedItemId = viewModel.selectedItemId.value
            val isSelected = selectedItemId == item.id
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .width(100.dp)
                    .height(80.dp)
                    .clickable { if (selectedItemId == item.id) {
                        selectedItemId = null
                    } else {
                        selectedItemId = item.id
                    } },
                shape = roundedRectangleShape,
                elevation = 4.dp,
                backgroundColor = item.color,
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    if (selectedItemId == item.id) {
                        Icon(
                            painter = painterResource(id = R.drawable.check_icon),
                            contentDescription = "Selected",
                            tint = white,
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.TopEnd)
                                .padding(8.dp)
                        )
                    }
                }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = "Favorite icon",
                            tint = white,
                            modifier = Modifier.size(45.dp)
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
    Column {
        Text(
            modifier = Modifier.padding(start = 20.dp, top = 170.dp),
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
    }
    LazyRow(modifier = Modifier.padding(top = 220.dp)) {
        items(cardItems) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .width(120.dp)
                    .height(100.dp)
                    .clickable {  },
                shape = roundedRectangleShape,
                elevation = 4.dp,
                backgroundColor = white
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "Favorite icon",
                        tint = black,
                        modifier = Modifier.size(65.dp)
                    )
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.h4.copy(
                            color = black,
                            fontSize = 14.sp,
                            fontFamily = nunitoBold
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 0.dp)
                    )
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
