package com.zgsbrgr.demos.hart.ui_exhibitionlist

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zgsbrgr.demos.hart.core.domain.LoadingState
import com.zgsbrgr.demos.hart.core.domain.Result
import com.zgsbrgr.demos.hart.core.util.ErrorMessage
import com.zgsbrgr.demos.hart.domain.interactors.LoadExhibitions
import com.zgsbrgr.demos.hart.domain.model.Exhibition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

data class ExhibitionListUiState(
    val exhibitions: List<Exhibition> = emptyList(),
    val loading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList()
) {
    val initialLoad: Boolean
        get() = exhibitions.isEmpty() && errorMessages.isEmpty() && loading

}

@HiltViewModel
class ExhibitionListViewModel
@Inject constructor(
    private val loadExhibitions: LoadExhibitions
) : ViewModel() {


    //val uiState: MutableState<ExhibitionListUiState> = mutableStateOf(ExhibitionListUiState(loading = true))
    private val _uiState = MutableStateFlow(ExhibitionListUiState(loading = true))
    val uiState: StateFlow<ExhibitionListUiState> = _uiState.asStateFlow()

    init {
        refreshExhibitions()
    }


    private fun refreshExhibitions() {

        _uiState.update {
            it.copy(loading = true)
        }
        loadExhibitions.retrieveExhibitions().onEach { response->
            _uiState.update {
                when(response) {
                    is Result.Success -> {
                        it.copy(exhibitions = response.data.second)
                    }
                    is Result.Error -> {
                        val errorMessage = uiState.value.errorMessages + ErrorMessage(
                            id = UUID.randomUUID().mostSignificantBits,
                            message = "Can't load exhibitions"
                        )
                        it.copy(errorMessages = errorMessage, loading = false)

                    }
                    is Result.Loading -> {
                        if(response.state == LoadingState.Loading) {
                            it.copy(loading = true)
                        }
                        else {
                            it.copy(loading = false)
                        }
                    }
                }
            }

        }.launchIn(viewModelScope)



    }

}