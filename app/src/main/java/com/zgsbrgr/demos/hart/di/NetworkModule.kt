package com.zgsbrgr.demos.hart.di

import com.google.gson.GsonBuilder
import com.zgsbrgr.demos.hart.data.network.Endpoints
import com.zgsbrgr.demos.hart.data.network.HExhibitionService
import com.zgsbrgr.demos.hart.data.network.HObjectService
import com.zgsbrgr.demos.hart.data.network.HartService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(30L, TimeUnit.SECONDS)
        httpClient.readTimeout(30L, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun provideHartService(retrofit: Retrofit): HartService {
        return retrofit.create(HartService::class.java)
    }

    @Singleton
    @Provides
    fun provideHartExhibitionService(retrofit: Retrofit): HExhibitionService {
        return retrofit.create(HExhibitionService::class.java)
    }

    @Singleton
    @Provides
    fun provideHartObjectService(retrofit: Retrofit): HObjectService {
        return retrofit.create(HObjectService::class.java)
    }

}