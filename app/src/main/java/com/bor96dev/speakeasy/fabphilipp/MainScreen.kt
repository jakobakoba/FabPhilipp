package com.bor96dev.speakeasy.fabphilipp

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable



@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.MainScreen(
    fabColor: androidx.compose.ui.graphics.Color,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onFabClick: () -> Unit,
    ) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFabClick,
                containerColor = fabColor,
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(FAB_EXPLODE_BOUNDS_KEY),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
            ) {
                Icon (
                    imageVector = Icons.Default.Add,
                    contentDescription = "add item"
                )
            }
        }
    ) { innerPadding ->

        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            Text("Main content")

        }

    }

}