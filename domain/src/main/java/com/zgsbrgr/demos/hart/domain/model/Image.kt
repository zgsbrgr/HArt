package com.zgsbrgr.demos.hart.domain.model

data class Image(
    val id: Int,
    val format: String,
    val date: String,
    val description: String,
    val caption: String,
    val baseImageUrl: String,
    val width: Int,
    val height: Int,
    val technique: String
)
