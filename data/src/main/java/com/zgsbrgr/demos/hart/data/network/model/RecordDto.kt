package com.zgsbrgr.demos.hart.data.network.model

import com.google.gson.annotations.SerializedName

data class RecordDto(

    @SerializedName("images")
    var images: List<ImageDto> = emptyList(),

    @SerializedName("begindate")
    var beginDate: String,

    @SerializedName("description")
    var description: String,

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
    var endDate: String,

    @SerializedName("venues")
    var venues: List<VenueDto> = emptyList(),

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