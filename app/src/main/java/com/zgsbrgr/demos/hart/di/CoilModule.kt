package com.zgsbrgr.demos.hart.di

import android.app.Application
import coil.ImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object CoilModule {

    @Provides
    @Singleton
    fun provideImageLoader(app: Application): ImageLoader {

        return ImageLoader.Builder(app)
            .error(android.R.drawable.stat_notify_error)
            .placeholder(android.R.drawable.alert_light_frame)
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()
    }

}