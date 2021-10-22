package com.zgsbrgr.demos.hart.ui_exhibition_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zgsbrgr.demos.hart.core.domain.LoadingState
import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.core.util.ErrorMessage
import com.zgsbrgr.demos.hart.domain.interactors.LoadExhibition
import com.zgsbrgr.demos.hart.domain.model.SingleExhibition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


data class ExhibitionUIState(
    val exhibition: SingleExhibition? = null,
    val loading: Boolean = false,
    val errorMessage: List<ErrorMessage> = emptyList()
)

@HiltViewModel
class ExhibitionViewModel
@Inject constructor(
    private val loadSingleExhibition: LoadExhibition,
    savedStateHandle: SavedStateHandle
): ViewModel() {


    private val exhibitionId: Int = savedStateHandle.get<Int>("exhibitionId")!!

    private val _uiState = MutableStateFlow(ExhibitionUIState(loading = true))
    val uiState: StateFlow<ExhibitionUIState> = _uiState.asStateFlow()


    init {
        _uiState.update {
            it.copy(loading = true)
        }
        viewModelScope.launch {
            val response = loadSingleExhibition(exhibitionId)
            _uiState.update {
                when(response) {
                    is Result.Success -> {
                        it.copy(exhibition = response.data)
                    }
                    is Result.Error -> {
                        val errorMessage = uiState.value.errorMessage + ErrorMessage(
                            id = UUID.randomUUID().mostSignificantBits,
                            message = "Can't load exhibition with $exhibitionId"
                        )
                        it.copy(errorMessage = errorMessage, loading = false)
                    }
                    is Result.Loading -> {
                        if(response.state == LoadingState.Loading)
                            it.copy(loading = true)
                        else
                            it.copy(loading = false)
                    }
                }
            }
        }
    }

}