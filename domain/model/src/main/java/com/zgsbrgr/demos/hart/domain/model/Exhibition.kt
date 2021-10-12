package com.zgsbrgr.demos.hart.domain.model


data class Exhibition(
    val exhibitionId: Int,
    val description: String,
    val images: List<Image>,
    val title: String,
    val primaryImageUrl: String,
    val url: String,
    val endDate: String,
    val beginDate: String,
    val lastUpdate: String,
    //val venues: List<Venue>,
    val poster: Poster
    )

data class Poster(
    val imageUrl: String,
    val caption: String
)

data class ResponseInfo(
    val totalRecordsPerQuery: Int,
    val totalRecords: Int,
    val pages: Int,
    val page: Int,
    val nextUrl: String
)

