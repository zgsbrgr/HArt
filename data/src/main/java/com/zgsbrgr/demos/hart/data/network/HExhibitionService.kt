package com.zgsbrgr.demos.hart.data.network

import com.zgsbrgr.demos.hart.data.BuildConfig
import com.zgsbrgr.demos.hart.data.network.model.ExhibitionResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HExhibitionService {

    @GET("exhibition")
    suspend fun getExhibitions(
        @Query("apikey") apiKey: String = BuildConfig.API_KEY,
        @Query("hasimage") hasImage: Int
    ): ExhibitionResponse

}