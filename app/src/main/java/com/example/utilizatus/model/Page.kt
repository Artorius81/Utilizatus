package com.example.utilizatus.model

import androidx.annotation.DrawableRes
import com.example.utilizatus.R

data class Page(val title: String , val description : String,
                @DrawableRes val image: Int)

val onboardPages = listOf(
    Page(
        "Сортировка",
        "Сканируйте предмет, чтобы узнать как именно стоит его сортировать",
        R.drawable.sort_onboard
    ),
    Page(
        "Поиск",
        "Узнайте, где находится ближайший пункт сортировки мусора",
        R.drawable.search_onboard
    ),
    Page(
        "Потрясающе!",
        "Отсортировав мусор, Вы помогли планете. Так держать!",
        R.drawable.awesome_onboard
    )

)