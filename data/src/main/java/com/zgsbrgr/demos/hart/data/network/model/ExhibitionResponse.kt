package com.zgsbrgr.demos.hart.data.network.model

import com.google.gson.annotations.SerializedName

data class ExhibitionResponse(

    @SerializedName("records")
    var exhibitionRecords: List<RecordDto> = emptyList(),

    @SerializedName("info")
    var info: InfoDto

)

data class InfoDto(

    @SerializedName("totalrecordsperquery")
    var totalRecordsPerQuery: Int,

    @SerializedName("totalrecords")
    var totalRecords: Int,

    @SerializedName("pages")
    var pages: Int,

    @SerializedName("page")
    var page: Int,

    @SerializedName("next")
    var next: String

    )
