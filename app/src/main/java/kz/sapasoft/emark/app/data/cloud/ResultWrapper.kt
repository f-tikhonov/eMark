package kz.sapasoft.emark.app.data.cloud

import kz.sapasoft.emark.app.domain.model.response.ErrorStatus

sealed class ResultWrapper<out T> {

    data class Success<T>(val value: T) : ResultWrapper<T>()

    data class Error(
        val status: ErrorStatus? = null,
        val code: Int? = null,
        val message: String? = null
    ) : ResultWrapper<Nothing>()
}