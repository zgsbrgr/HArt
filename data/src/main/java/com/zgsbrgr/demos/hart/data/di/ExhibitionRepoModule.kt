package com.zgsbrgr.demos.hart.data.di

import com.zgsbrgr.demos.hart.core.util.BackgroundDispatcher
import com.zgsbrgr.demos.hart.data.network.HExhibitionService
import com.zgsbrgr.demos.hart.data.repository.ExhibitionRepositoryImpl
import com.zgsbrgr.demos.hart.domain.interactors.ExhibitionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExhibitionRepoModule {

    @Singleton
    @Provides
    fun provideExhibitionRepository(exhibitionService: HExhibitionService, backgroundDispatcher: BackgroundDispatcher): ExhibitionRepository {
        return ExhibitionRepositoryImpl(exhibitionService, backgroundDispatcher)
    }
}