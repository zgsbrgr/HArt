package com.zgsbrgr.demos.hart.domain.interactors

import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.domain.model.SingleExhibition
import javax.inject.Inject

class LoadExhibition @Inject constructor(
    private val exhibitionRepository: ExhibitionRepository
) {

    suspend operator fun invoke(exhibitionId: Int): Result<SingleExhibition> {
        return exhibitionRepository.getExhibition(exhibitionId)
    }

}