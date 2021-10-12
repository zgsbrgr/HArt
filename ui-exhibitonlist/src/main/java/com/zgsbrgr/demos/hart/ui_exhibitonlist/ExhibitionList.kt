package com.zgsbrgr.demos.hart.ui_exhibitonlist

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.zgsbrgr.demos.hart.ui_exhibitonlist.components.ExhibitionItem

@ExperimentalAnimationApi
@Composable
fun ExhibitionList(
    state: ExhibitionListUiState,
    navigateToDetailScreen: (Int) -> Unit,
    imageLoader: ImageLoader
) {

    Box(
       modifier = Modifier.fillMaxSize()
    ) {
        Log.d("ExhibitionList", "state change list size is: ${state.exhibitions.size.toString()}")
        AnimatedVisibility(visible = state.exhibitions.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                items(state.exhibitions) { exhibition ->
                    ExhibitionItem(
                        exhibition = exhibition,
                        onSelectExhibition = navigateToDetailScreen,
                        imageLoader = imageLoader
                    )
                }
            }
        }
    }

}