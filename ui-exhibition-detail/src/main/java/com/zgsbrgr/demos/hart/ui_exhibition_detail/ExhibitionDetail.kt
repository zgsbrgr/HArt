package com.zgsbrgr.demos.hart.ui_exhibition_detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import coil.ImageLoader

@ExperimentalAnimationApi
@Composable
fun ExhibitionDetail(
    state: ExhibitionUIState,
    imageLoader: ImageLoader,
    onBack: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text( text="Exhibition")},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "",
                            tint = MaterialTheme.colors.primary
                        )
                    }
                },
                backgroundColor = Color.Yellow
            )
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                AnimatedVisibility(visible = state.exhibition != null) {
                    state.exhibition?.let {
                        Text(text = it.title)
                    }
                }
            }
        }

    )


}