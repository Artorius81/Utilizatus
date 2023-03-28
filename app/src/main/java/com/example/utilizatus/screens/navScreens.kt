package com.example.utilizatus.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
import com.example.utilizatus.notification.OTPNumber
import com.example.utilizatus.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.togitech.ccp.component.TogiCountryCodePicker
import compose.icons.FeatherIcons
import compose.icons.feathericons.Eye
import compose.icons.feathericons.EyeOff
import compose.icons.feathericons.Lock
import compose.icons.feathericons.User
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
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
fun BottomSheetContent(cardItem: CardMore, itemList: List<Item>) {
    val nunitoBold = FontFamily(Font(R.font.nunito_bold))
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    var backColor = mutableListOf<Color>()
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
        modifier = Modifier.height(400.dp)) {
        Box(modifier = Modifier.fillMaxSize().background(brush)) {
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
                        text = cardItem.description,
                        style = MaterialTheme.typography.h6.copy(
                            color = white,
                            fontSize = 16.sp,
                            fontFamily = nunitoMedium
                        ),
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(top = 8.dp, start = 5.dp, end = 5.dp)
                    )
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
        CardMore(11, "Макулатура", R.drawable.paper, "В эту категорию входят газеты, журналы, бумага для принтера, карточки, письма и другие бумажные изделия. Макулатуру можно перерабатывать и использовать в качестве сырья для производства новой бумаги. На одну тонну переработанной макулатуры можно сохранить 17 деревьев и 7,000 галлонов воды.", intArrayOf(0, 1)),
        CardMore(12, "Бутылки", R.drawable.bottles, "Эта категория включает в себя стеклянные и пластиковые бутылки. Стеклянные бутылки можно перерабатывать и использовать снова и снова без потери качества, а пластиковые бутылки могут быть переработаны в множество различных продуктов, включая одежду и коврики. Одна стеклянная бутылка, переработанная вместо выбрасывания, может осветить лампочку мощностью 100 ватт на 4 часа.", intArrayOf(0, 2, 4)),
        CardMore(13, "Флаконы", R.drawable.vials, "Флаконы из стекла и пластика, используемые для лекарств и косметических продуктов, относятся к этой категории. Как и в случае с бутылками, стеклянные флаконы можно перерабатывать многократно. Пластиковые флаконы могут быть переработаны в качестве материала для изготовления других продуктов, включая садовые инструменты и мебель.", intArrayOf(0, 2, 4)),
        CardMore(14, "Метал. банки", R.drawable.metal_jar, "Эта категория включает в себя банки из алюминия и стали, используемые для консервирования продуктов питания. Металлические банки можно перерабатывать и использовать в качестве сырья для производства новых банок, автомобилей и даже самолетов. Одну алюминиевую банку можно переработать и использовать для производства новых банок в течение всего 60 дней.", intArrayOf(0, 3)),
        CardMore(15, "Ткань", R.drawable.cloth, "Эта категория включает в себя старую одежду, постельное белье, полотенца и другие текстильные изделия. Ткань можно перерабатывать и использовать в качестве сырья для производства новых текстильных изделий. Переработка ткани также может сэкономить до 90% воды и энергии, которые используются при производстве новой ткани. Некоторые компании также собирают старую одежду для переработки в качестве утеплителя для домов и зданий.", intArrayOf(0, 6)),
        CardMore(16, "Стекло", R.drawable.glass, "В эту категорию входят стеклянные бутылки, окна, зеркала и другие изделия из стекла. Стекло можно перерабатывать и использовать в качестве сырья для производства нового стекла, при этом сокращается количество необходимых сырьевых материалов и энергии. Одна тонна переработанного стекла может сэкономить до 1.2 тонн сырья и 130 кг углекислого газа.", intArrayOf(0, 2)),
        CardMore(17, "Лекарства", R.drawable.medicine, "Эта категория включает в себя просроченные или ненужные лекарства, которые необходимо утилизировать безопасным способом. Лекарства не должны выбрасываться в мусор, т.к. могут вызвать загрязнение водных ресурсов и опасность для здоровья людей и животных. Некоторые аптеки и больницы предоставляют возможность сдать устаревшие лекарства для безопасной утилизации.", intArrayOf(0, 7)),
        CardMore(18, "Техника", R.drawable.electr, "Эта категория включает в себя старые компьютеры, телефоны, телевизоры и другие электронные устройства. Утилизация электроники требует специального подхода, т.к. может содержать опасные химические вещества. Многие компании принимают электронику и перерабатывают ее, используя ценные ресурсы, такие как золото, серебро и медь, в качестве сырья для производства новых устройств.", intArrayOf(0, 3, 8, 9)),
        CardMore(19, "Мебель", R.drawable.furn, "Эта категория включает в себя старую или поврежденную мебель, которая должна быть утилизирована безопасным способом. Мебель может содержать токсичные химические вещества, которые могут загрязнить окружающую среду, если выброшены на свалку. Многие компании предлагают услуги по утилизации мебели, а также перерабатывают ее в качестве сырья для производства новых мебельных изделий.", intArrayOf(0, 6)),
        CardMore(20, "Пищ. отходы", R.drawable.food_waste, "Эта категория включает в себя остатки пищи, которые могут быть утилизированы путем компостирования. Компостирование - это процесс переработки органических отходов в питательную почву. Компост можно использовать в качестве удобрения для растений и садов. Компостирование пищевых отходов также может сократить количество отходов, которые попадают на свалку.", intArrayOf(0, 5)),
        CardMore(21, "Батарейки", R.drawable.battery, "Эта категория включает в себя старые или ненужные батарейки, которые должны быть утилизированы безопасным способом. Батареи могут содержать токсичные химические вещества, которые могут вызвать загрязнение окружающей среды, если выброшены на свалку. Некоторые компании предлагают услуги по утилизации батареек, а также собирают их для переработки и использования ценных материалов, таких как цинк и марганец.", intArrayOf(0, 7, 9))
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

    var selectedCard by remember { mutableStateOf<CardMore?>(null) }

    val showModalSheet = rememberSaveable {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
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
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                            .height(80.dp)
                            .clickable {  },
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
                    .clickable { },
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

    //val showModalSheet = rememberSaveable {
    //    mutableStateOf(false)
    //}

    if (selectedCard != null) {
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetContent = { BottomSheetContent(cardItem = selectedCard!!, itemList = itemList) },
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
