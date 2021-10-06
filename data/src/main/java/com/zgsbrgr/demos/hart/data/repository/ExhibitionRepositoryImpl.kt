package com.zgsbrgr.demos.hart.data.repository

import com.zgsbrgr.demos.hart.core.domain.LoadingState
import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.core.util.BackgroundDispatcher
import com.zgsbrgr.demos.hart.data.network.HExhibitionService
import com.zgsbrgr.demos.hart.data.network.model.toExhibitionList
import com.zgsbrgr.demos.hart.data.network.model.toResponseInfo
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.domain.model.ResponseInfo
import com.zgsbrgr.demos.hart.domain.repositories.ExhibitionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExhibitionRepositoryImpl
    @Inject constructor(
        private val exhibitionService: HExhibitionService,
        private val backgroundDispatcher: BackgroundDispatcher
    ):ExhibitionRepository {

    override suspend fun getExhibitions(): Flow<Result<Pair<ResponseInfo,List<Exhibition>>>> = flow {

        try {
            emit(Result.Loading(LoadingState.Loading))

            val response = try {
                exhibitionService.getExhibitions("", 1)
            }catch (e: Exception) {
                emit(Result.Error(e))
                null
            }

            response?.let {
                emit(
                    Result.Success(
                        Pair(
                            it.info.toResponseInfo(),
                            it.exhibitionRecords.toExhibitionList()
                        )
                    )
                )
            }

        }finally {
            emit(Result.Loading(LoadingState.Idle))
        }

    }.flowOn(backgroundDispatcher)
}