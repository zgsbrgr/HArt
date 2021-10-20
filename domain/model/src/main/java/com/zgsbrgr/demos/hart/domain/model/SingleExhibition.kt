package com.zgsbrgr.demos.hart.domain.model

data class SingleExhibition(
    val beginDate: String,
    val endDate: String,
    val color: String,
    val description: String,
    val exhibitionId: Int,
    val id: Int,
    val images: List<Image>,
    val lastUpdate: String,
    val poster: Poster?,
    val primaryImageUrl: String,
    val publications: List<Publication>,
    val shortDescription: String,
    val temporalOrder: Int,
    val title: String,
    val venues: List<Venue>,
    val videos: List<Video>
)
