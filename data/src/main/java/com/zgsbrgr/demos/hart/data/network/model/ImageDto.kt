package com.zgsbrgr.demos.hart.data.network.model

import com.google.gson.annotations.SerializedName
import javax.management.monitor.StringMonitor

data class ImageDto(

    @SerializedName("date")
    var dateStr: String,

    @SerializedName("copyright")
    var copyright: String,

    @SerializedName("imageid")
    var imageId: Int,

    @SerializedName("idsid")
    var idsid: Int,

    @SerializedName("format")
    var format: String,

    @SerializedName("caption")
    var caption: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("technique")
    var technique: String?,

    @SerializedName("renditionnumber")
    var renditionNumber: String,

    @SerializedName("displayorder")
    var displayOrder: Int,

    @SerializedName("baseimageurl")
    var baseImageUrl: String,

    @SerializedName("alttext")
    var altText: String?,

    @SerializedName("width")
    var width: Int,

    @SerializedName("height")
    var height: Int,

    @SerializedName("iiifbaseuri")
    var iiifbaseuri: String

    )
