package com.zgsbrgr.demos.hart.domain.model

data class Venue(
    val id: Int,
    val zipCode: String,
    val country: String,
    val city: String,
    val state: String,
    val primaryAddress: String,
    val secondaryAddress: String,
    val name: String,
    val fullName: String,
    val beginDate: String,
    val endDate: String
)
