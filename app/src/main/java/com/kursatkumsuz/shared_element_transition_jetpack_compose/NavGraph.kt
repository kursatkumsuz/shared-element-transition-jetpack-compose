package com.kursatkumsuz.shared_element_transition_jetpack_compose

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kursatkumsuz.shared_element_transition_jetpack_compose.screens.DetailScreen
import com.kursatkumsuz.shared_element_transition_jetpack_compose.screens.HomeScreen
import com.kursatkumsuz.shared_element_transition_jetpack_compose.util.Screen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavGraph(navController: NavHostController) {
    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
            composable(Screen.HomeScreen.route) {
                HomeScreen(
                    animatedVisibilityScope = this,
                    onNavigateDetailScreen = { resId, name ->
                        navController.navigate("${Screen.DetailScreen.route}/$resId/$name")
                    })
            }
            composable(
                "${Screen.DetailScreen.route}/{resId}/{name}",
                arguments = listOf(
                    navArgument("resId") { type = NavType.IntType },
                    navArgument("name") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val resId = backStackEntry.arguments?.getInt("resId") ?: R.drawable.pic_istanbul
                val name = backStackEntry.arguments?.getString("name") ?: ""

                DetailScreen(animatedVisibilityScope = this, resId = resId, name = name)
            }
        }
    }
}