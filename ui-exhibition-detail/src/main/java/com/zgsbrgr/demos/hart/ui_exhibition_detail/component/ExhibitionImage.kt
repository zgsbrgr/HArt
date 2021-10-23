package com.zgsbrgr.demos.hart.ui_exhibition_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.zgsbrgr.demos.hart.domain.model.Image

@ExperimentalCoilApi
@Composable
fun ExhibitionImage(
    image: Image,
    imageLoader: ImageLoader,
    modifier: Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.size(280.dp, 240.dp)
    ) {
        val painter = rememberImagePainter(
            image.baseImageUrl,
            imageLoader = imageLoader,
        )
        val imageModifier = Modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)
        Column {
            Image(
                painter = painter,
                contentDescription = image.caption,
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )

        }

    }



    
}