package com.zgsbrgr.demos.hart.ui_exhibitionlist

import android.content.res.Resources
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.zgsbrgr.demos.hart.ui_exhibitionlist.components.ExhibitionItem

@ExperimentalCoilApi
@ExperimentalAnimationApi
@Composable
fun ExhibitionList(
    state: ExhibitionListUiState,
    navigateToDetailScreen: (Int) -> Unit,
    imageLoader: ImageLoader,
    resources: Resources
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold (
        scaffoldState =  scaffoldState,
        topBar = { AppTopBar(resources) },
        content = {
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

    )



}

@Composable
fun AppTopBar(resources: Resources) {
    TopAppBar(
        title = { Text(text = resources.getString(R.string.app_name)) },
        backgroundColor = Color.Yellow
    )
}

