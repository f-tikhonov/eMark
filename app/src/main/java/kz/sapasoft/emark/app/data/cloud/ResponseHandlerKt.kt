import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.domain.model.response.ErrorResponse
import kz.sapasoft.emark.app.domain.model.response.ErrorStatus
import retrofit2.HttpException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            Log.d("terra", "apiCall()")
            ResultWrapper.Success(apiCall())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    Log.d("terra", "HttpException ${throwable.message()}")
                    ResultWrapper.Error(
                        ErrorStatus.BAD_RESPONSE,
                        throwable.code(),
                        convertErrorBody(throwable)
                    )
                }
                else -> {
                    Log.d("terra", "other else ${throwable.message}")
                    ResultWrapper.Error(ErrorStatus.NOT_DEFINED, null, throwable.message)
                }
            }
        }
    }
}

fun convertErrorBody(throwable: HttpException): String {
    return try {
        val errorBody = throwable.response()?.errorBody()?.string()
        val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
        val code = errorResponse?.code ?: ""
        val details = errorResponse?.details ?: ""

        if (code.isNotBlank() && details.isNotBlank()) "$code $details"
        else code.ifBlank { details }
    } catch (e: Exception) {
        ""
    }
}
