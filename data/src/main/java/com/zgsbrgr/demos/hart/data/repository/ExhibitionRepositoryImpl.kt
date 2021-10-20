package com.zgsbrgr.demos.hart.data.repository

import android.util.Log
import com.zgsbrgr.demos.hart.core.domain.LoadingState
import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.core.util.BackgroundDispatcher
import com.zgsbrgr.demos.hart.data.network.HExhibitionService
import com.zgsbrgr.demos.hart.data.network.model.toExhibitionList
import com.zgsbrgr.demos.hart.data.network.model.toResponseInfo
import com.zgsbrgr.demos.hart.data.network.model.toSingleExhibition
import com.zgsbrgr.demos.hart.domain.interactors.BuildConfig
import com.zgsbrgr.demos.hart.domain.interactors.ExhibitionRepository
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.domain.model.ResponseInfo
import com.zgsbrgr.demos.hart.domain.model.SingleExhibition

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


class ExhibitionRepositoryImpl
    @Inject constructor(
        private val exhibitionService: HExhibitionService,
        private val backgroundDispatcher: BackgroundDispatcher
    ): ExhibitionRepository {

    override fun getExhibitions(): Flow<Result<Pair<ResponseInfo,List<Exhibition>>>> = flow {

        try {
            Log.d("called", "")
            emit(Result.Loading(LoadingState.Loading))

            val response = try {
                exhibitionService.getExhibitions( com.zgsbrgr.demos.hart.data.BuildConfig.API_KEY , 1, "current")
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


        }catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(e))
        }finally {
            emit(Result.Loading(LoadingState.Idle))
        }

    }.flowOn(backgroundDispatcher)


    override suspend fun getExhibition(exhibitionId: Int): Result<SingleExhibition> = withContext(backgroundDispatcher) {
        return@withContext try {

            val response = exhibitionService.getExhibition( com.zgsbrgr.demos.hart.data.BuildConfig.API_KEY, exhibitionId)
            Result.Success(response.toSingleExhibition())

        }catch (e: Exception) {
            Result.Error(e)
        }
    }

}