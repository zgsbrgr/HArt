package com.zgsbrgr.demos.hart.domain.interactors

import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import com.zgsbrgr.demos.hart.domain.model.ResponseInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadExhibitions @Inject constructor(
    private val exhibitionRepository: ExhibitionRepository
) {

    suspend operator fun invoke(): Flow<Result<Pair<ResponseInfo, List<Exhibition>>>> {
        return exhibitionRepository.getExhibitions()
    }
}