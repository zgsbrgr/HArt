package com.zgsbrgr.demos.hart.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface HExhibitionService {


    @GET("exhibition")
    suspend fun getExhibitions(
        @Query("apikey") apiKey: String,
        @Query("hasimage") hasImage: Int
    )

}