package com.zgsbrgr.demos.hart.data.di

import com.zgsbrgr.demos.hart.core.util.BackgroundDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun provideBackgroundDispatcher() = BackgroundDispatcher

}