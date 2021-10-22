package com.zgsbrgr.demos.hart.ui_exhibitionlist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.zgsbrgr.demos.hart.common_ui_compose.theme.ZComposeTheme
import com.zgsbrgr.demos.hart.common_ui_compose.theme.ZHartTypography
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.ui_exhibitionlist.ExhibitionListUiState
import com.zgsbrgr.demos.hart.ui_exhibitionlist.ExhibitionListViewModel
import kotlin.math.round

@ExperimentalCoilApi
@Composable
fun ExhibitionItem(
    exhibition: Exhibition,
    onSelectExhibition: (Int) -> Unit,
    imageLoader: ImageLoader
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
            .background(MaterialTheme.colors.surface)
            .clickable {
                onSelectExhibition(exhibition.exhibitionId)
            }
        ,
        elevation = 8.dp
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically
        ){
            val painter = rememberImagePainter(
                exhibition.primaryImageUrl,
                imageLoader = imageLoader,
                builder = {
                    placeholder(if(isSystemInDarkTheme()) android.R.drawable.alert_dark_frame else android.R.drawable.alert_light_frame)
                }
            )
            Image(
                modifier = Modifier
                    .width(120.dp)
                    .height(200.dp)
                ,
                painter = painter,
                contentDescription = exhibition.title,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(.8f) // fill 80% of remaining width
                    .padding(start = 12.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .testTag("TAG_EXHIBITION_TITLE")
                    ,
                    text = exhibition.title,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .testTag("TAG_HERO_PRIMARY_ATTRIBUTE")
                    ,
                    text = exhibition.description.let {
                        if(it.isEmpty()) "here comes the description" else it
                    }, //exhibition.description,
                    style = MaterialTheme.typography.subtitle2,
                )
            }


        }
    }

}

