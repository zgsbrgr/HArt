package com.zgsbrgr.demos.hart.core.domain

import java.lang.Exception

/**
 * A generic class that holds a value with its loading status
 * @param <T>
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception): Result<Nothing>()
    data class Loading<T>(val state: LoadingState = LoadingState.Idle): Result<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading[state=$state]"
        }
    }

}

sealed class LoadingState {
    object Loading: LoadingState()
    object Idle: LoadingState()
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data]
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null