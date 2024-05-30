package com.kursatkumsuz.shared_element_transition_jetpack_compose.model

import androidx.annotation.DrawableRes

data class City(
    val name : String,
    @DrawableRes val pic : Int,
)