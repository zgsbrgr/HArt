package com.zgsbrgr.demos.hart.domain.interactors


import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.domain.model.ResponseInfo
import com.zgsbrgr.demos.hart.domain.model.SingleExhibition
import kotlinx.coroutines.flow.Flow


interface ExhibitionRepository {

    fun getExhibitions(): Flow<Result<Pair<ResponseInfo,List<Exhibition>>>>

    suspend fun getExhibition(exhibitionId: Int): Result<SingleExhibition>

}