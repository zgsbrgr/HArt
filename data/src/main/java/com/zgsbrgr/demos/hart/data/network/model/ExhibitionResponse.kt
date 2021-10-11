package com.zgsbrgr.demos.hart.data.network.model

import com.google.gson.annotations.SerializedName
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.domain.model.ResponseInfo


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

fun List<RecordDto>.toExhibitionList(): List<com.zgsbrgr.demos.hart.domain.model.Exhibition> {
    return map { recordDto ->
        recordDto.toExhibition()
    }
}

fun InfoDto.toResponseInfo(): com.zgsbrgr.demos.hart.domain.model.ResponseInfo {
    return com.zgsbrgr.demos.hart.domain.model.ResponseInfo(
        totalRecordsPerQuery = totalRecordsPerQuery,
        totalRecords = totalRecords,
        pages = pages,
        page = page,
        nextUrl = next
    )
}