package com.zgsbrgr.demos.hart.data.network.model

import com.google.gson.annotations.SerializedName

data class VenueDto(

    @SerializedName("zipcode")
    var zipCode: String,

    @SerializedName("country")
    var country: String?,

    @SerializedName("begindate")
    var beginDate: String,

    @SerializedName("enddate")
    var endDate: String,

    @SerializedName("address2")
    var address2: String?,

    @SerializedName("city")
    var city: String,

    @SerializedName("address1")
    var address1: String,

    @SerializedName("venueid")
    var venueId: Int,

    @SerializedName("ishamvenue")
    var isHamVenue: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("fullname")
    var fullName: String,

    @SerializedName("state")
    var state: String


    )