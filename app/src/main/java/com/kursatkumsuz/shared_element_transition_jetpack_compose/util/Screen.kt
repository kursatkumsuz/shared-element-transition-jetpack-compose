package com.kursatkumsuz.shared_element_transition_jetpack_compose.util

sealed class Screen (val route : String) {
    data object HomeScreen : Screen(route = "home_screen")
    data object DetailScreen : Screen(route = "detail_screen")
}