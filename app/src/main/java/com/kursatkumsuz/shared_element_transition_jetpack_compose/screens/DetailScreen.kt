package com.kursatkumsuz.shared_element_transition_jetpack_compose.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.DetailScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    resId: Int,
    name: String
) {
    Box {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
                .sharedElement(
                    state = rememberSharedContentState(
                        key = "image-${resId}"
                    ),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { _, _ ->
                        tween(durationMillis = 1000)
                    }
                ),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = resId),
            contentDescription = "List Image"
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(40.dp)
                .sharedElement(
                    state = rememberSharedContentState(
                        key = "name-${name}"
                    ),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { _, _ ->
                        tween(durationMillis = 1000)
                    }
                ),
            text = name,
            fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}