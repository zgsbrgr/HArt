package com.zgsbrgr.demos.hart.data.mapper

interface Mapper<F, T> {
    suspend fun map(from: F): T
}
