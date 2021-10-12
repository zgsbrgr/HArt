package com.zgsbrgr.demos.hart.data.network.model

import com.google.gson.annotations.SerializedName
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.domain.model.Poster

data class RecordDto(

    @SerializedName("images")
    var images: List<ImageDto> = emptyList(),

    @SerializedName("begindate")
    var beginDate: String,

    @SerializedName("description")
    var description: String?,

    @SerializedName("exhibitonid")
    var exhibitionId: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("primaryimageurl")
    var primaryImageUrl: String,

    @SerializedName("temporalorder")
    var temporalOrder: Int,

    @SerializedName("url")
    var url: String,

    @SerializedName("enddate")
    var endDate: String?,

//    @SerializedName("venues")
//    var venues: List<VenueDto> = emptyList(),

    @SerializedName("id")
    var id: Int,

    @SerializedName("lastupdate")
    var lastUpdate: String,

    @SerializedName("poster")
    var posterDto: PosterDto


    )

data class PosterDto(

    @SerializedName("imageurl")
    var imageUrl: String,

    @SerializedName("caption")
    var caption: String?

    )

fun RecordDto.toExhibition(): Exhibition {
    return Exhibition(
        exhibitionId = exhibitionId,
        description = description?:"",
        images = images.toImageList(),
        title = title,
        primaryImageUrl = primaryImageUrl,
        url = url,
        endDate = endDate?:"",
        beginDate = beginDate,
        lastUpdate = lastUpdate,
        //venues = venues?.toVenueList(),
        poster = posterDto.toPoster()

    )
}

fun PosterDto.toPoster(): Poster {
    return Poster(
        imageUrl = imageUrl,
        caption = caption ?: ""
    )
}