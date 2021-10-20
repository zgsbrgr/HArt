package com.zgsbrgr.demos.hart.domain.model


data class Publication(
    val description: String,
    val format: String,
    val primaryImageUrl: String,
    val publicationDate: String,
    val publicationId: Int,
    val publicationPlace:  String,
    val publicationYear: Int,
    val shortDescription: String,
    val title: String
)

