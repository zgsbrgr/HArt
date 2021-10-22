package com.zgsbrgr.demos.hart.data.network.model


import com.google.gson.annotations.SerializedName
import com.zgsbrgr.demos.hart.domain.model.SingleExhibition

data class ExhibitionDto(
    @SerializedName("begindate")
    var begindate: String?,
    @SerializedName("color")
    var color: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("enddate")
    var enddate: String?,
    @SerializedName("exhibitionid")
    var exhibitionid: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("images")
    var images: List<ImageDto>?,
    @SerializedName("lastupdate")
    var lastupdate: String?,
    @SerializedName("poster")
    var poster: PosterDto?,
    @SerializedName("primaryimageurl")
    var primaryimageurl: String?,
    @SerializedName("publications")
    var publications: List<PublicationDto>?,
    @SerializedName("shortdescription")
    var shortdescription: String?,
    @SerializedName("temporalorder")
    var temporalorder: Int,
    @SerializedName("title")
    var title: String?,
    @SerializedName("venues")
    var venues: List<VenueDto>?,
    @SerializedName("videos")
    var videos: List<VideoDto>?
)

fun ExhibitionDto.toSingleExhibition(): SingleExhibition {
    return SingleExhibition(
        beginDate = begindate?:"",
        endDate = enddate?:"",
        color = color?:"",
        description = description?:"",
        exhibitionId = exhibitionid,
        id = id,
        images = images?.toImageList() ?: emptyList(),
        lastUpdate = lastupdate?:"",
        poster = poster?.toPoster(),
        primaryImageUrl = primaryimageurl?:"",
        publications = publications?.toPublicationList() ?: emptyList(),
        shortDescription = shortdescription?:"",
        temporalOrder = temporalorder,
        title = title?:"",
        venues = venues?.toVenueList() ?: emptyList(),
        videos = videos?.toVideoList() ?: emptyList()
    )
}