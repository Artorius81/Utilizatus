package com.example.utilizatus.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.utilizatus.R

data class Page(@StringRes val title: Int , @StringRes val description : Int,
                @DrawableRes val image: Int)

val onboardPages = listOf(
    Page(
        R.string.sorting,
        R.string.sorting_tip,
        R.drawable.sort_onboard
    ),
    Page(
        R.string.searching,
        R.string.searching_tip,
        R.drawable.search_onboard
    ),
    Page(
        R.string.awesome,
        R.string.awesome_tip,
        R.drawable.awesome_onboard
    )

)