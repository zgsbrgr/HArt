package com.zgsbrgr.demos.hart.ui_exhibition_detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.zgsbrgr.demos.hart.domain.model.Image
import com.zgsbrgr.demos.hart.ui_exhibition_detail.component.ExhibitionImage

@ExperimentalCoilApi
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
                backgroundColor = Color.White
            )
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                //AnimatedVisibility(visible = state.exhibition != null) {
                    state.exhibition?.let { singleExhibition->
                        LazyColumn(
                            //modifier = Modifier.padding(8.dp)
                        ) {
                            item {
                                ExhibitionImages(
                                    images = singleExhibition.images,
                                    imageLoader = imageLoader
                                )
                            }
                            item {
                                Text(text = singleExhibition.title, style = MaterialTheme.typography.h4, modifier = Modifier.padding(8.dp))
                                Spacer(Modifier.height(8.dp))
                            }
                            item {
                                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                    Text(
                                        text = "${singleExhibition.beginDate} - ${singleExhibition.endDate}",
                                        style = MaterialTheme.typography.body2,
                                        lineHeight = 20.sp,
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                            item {
                                Text(
                                    text = singleExhibition.textileDescription,
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }

                        }

                    }
                //}
            }
        }

    )


}

@ExperimentalCoilApi
@Composable
fun ExhibitionImages(
    images: List<Image>,
    imageLoader: ImageLoader
) {
    Column {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Exhibition Images",
            style = MaterialTheme.typography.subtitle1

        )
        LazyRow(
            //modifier = Modifier.padding(end = 16.dp)
        ) {
            val imageList = arrayListOf<Image>()
            imageList.addAll(images)
            imageList.addAll(images)
            imageList.addAll(images)
            imageList.addAll(images)
            imageList.addAll(images)
            imageList.addAll(images)
            items(imageList) { image ->
                ExhibitionImage(
                    image = image,
                    imageLoader = imageLoader,
                    Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
        }

    }
}