package kz.sapasoft.emark.app.domain.model.response

data class ErrorModel(
    val message: String?,
    val code: Int?,
    var errorStatus: ErrorStatus
)