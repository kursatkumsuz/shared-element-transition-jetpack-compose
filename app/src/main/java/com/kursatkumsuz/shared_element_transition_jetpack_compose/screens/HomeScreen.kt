package com.kursatkumsuz.shared_element_transition_jetpack_compose.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kursatkumsuz.shared_element_transition_jetpack_compose.model.City
import com.kursatkumsuz.shared_element_transition_jetpack_compose.util.Cities.getCities

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.HomeScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    onNavigateDetailScreen: (Int, String) -> Unit
) {

    val cities = getCities()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier.padding(30.dp),
            text = "FEATURED CITIES",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
        )
        LazyRow(modifier = Modifier.fillMaxSize()) {
            items(cities.size) { index ->
                val city = cities[index]
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { onNavigateDetailScreen(city.pic, city.name) },
                ) {
                    Image(
                        modifier = Modifier
                            .size(width = 300.dp, height = 350.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .sharedElement(
                                state = rememberSharedContentState(
                                    key = "image-${city.pic}"
                                ),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(durationMillis = 1000)
                                }
                            ),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = city.pic),
                        contentDescription = "List Image"
                    )
                    Text(
                        modifier = Modifier
                            .sharedElement(
                                state = rememberSharedContentState(
                                    key = "name-${city.name}"
                                ),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(durationMillis = 1000)
                                }
                            ),
                        text = city.name,
                        fontSize = 26.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

