package com.zgsbrgr.demos.hart.domain.repositories

import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.domain.model.ResponseInfo
import kotlinx.coroutines.flow.Flow


interface ExhibitionRepository {

    suspend fun getExhibitions(): Flow<Result<Pair<ResponseInfo,List<Exhibition>>>>

}