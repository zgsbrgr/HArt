package com.zgsbrgr.demos.hart.ui_exhibitionlist

import android.content.res.Resources
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.zgsbrgr.demos.hart.common_ui_compose.theme.Domine
import com.zgsbrgr.demos.hart.common_ui_compose.theme.Montserrat
import com.zgsbrgr.demos.hart.ui_exhibitionlist.components.ExhibitionItem

@ExperimentalCoilApi
@ExperimentalAnimationApi
@Composable
fun ExhibitionList(
    state: ExhibitionListUiState,
    navigateToDetailScreen: (Int) -> Unit,
    imageLoader: ImageLoader
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold (
        scaffoldState =  scaffoldState,
        topBar = { AppTopBar() },
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
fun AppTopBar() {
    TopAppBar(
        title = {
            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    Text(
                        text = "hArt",
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.Black,
                            fontSize = 16.sp,
                            letterSpacing = 0.5.sp
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign =  TextAlign.Center
                    )
                }

            }
        },
        backgroundColor = Color.White,
        elevation = 2.dp,
        modifier= Modifier.fillMaxWidth()
    )
}

