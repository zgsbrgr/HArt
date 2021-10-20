package com.zgsbrgr.demos.hart.data.network.model


import com.google.gson.annotations.SerializedName
import com.zgsbrgr.demos.hart.domain.model.Publication

data class PublicationDto(
    @SerializedName("description")
    var description: String?,
    @SerializedName("format")
    var format: String?,
    @SerializedName("primaryimageurl")
    var primaryimageurl: String?,
    @SerializedName("publicationdate")
    var publicationdate: String?,
    @SerializedName("publicationid")
    var publicationid: Int,
    @SerializedName("publicationplace")
    var publicationplace: String?,
    @SerializedName("publicationyear")
    var publicationyear: Int,
    @SerializedName("shortdescription")
    var shortdescription: String?,
    @SerializedName("title")
    var title: String?
)

fun PublicationDto.toPublication(): Publication {
    return Publication(
        description = description?:"",
        format = format?:"",
        primaryImageUrl = primaryimageurl?:"",
        publicationDate = publicationdate?:"",
        publicationId = publicationid,
        publicationPlace = publicationplace?:"",
        publicationYear = publicationyear,
        shortDescription = shortdescription?:"",
        title = title?:""

    )
}

fun List<PublicationDto>.toPublicationList(): List<Publication> {
    return map { publicationDto ->
        publicationDto.toPublication()
    }
}