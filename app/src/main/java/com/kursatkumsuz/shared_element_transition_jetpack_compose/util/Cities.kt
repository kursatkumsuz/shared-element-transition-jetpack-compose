package com.kursatkumsuz.shared_element_transition_jetpack_compose.util

import com.kursatkumsuz.shared_element_transition_jetpack_compose.R
import com.kursatkumsuz.shared_element_transition_jetpack_compose.model.City

object Cities {
    fun getCities() : List<City> {
        return listOf(
            City(
                name = "Istanbul",
                pic = R.drawable.pic_istanbul
            ),
            City(
                name = "New York",
                pic = R.drawable.pic_newyork
            ),
            City(
                name = "Paris",
                pic = R.drawable.pic_paris
            )
        )
    }
}