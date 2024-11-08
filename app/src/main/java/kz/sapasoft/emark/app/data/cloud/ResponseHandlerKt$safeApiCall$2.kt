/*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.domain.model.response.ErrorStatus
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<out Any?> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is UnknownHostException -> ResultWrapper.Error(
                    ErrorStatus.NO_CONNECTION,
                    null,
                   " App.getInstance().getString(R.string.no_internet_connection)"
                )
                is HttpException -> {
                    val code = throwable.code()
                    ResultWrapper.Error(
                        ErrorStatus.BAD_RESPONSE,
                        code,
                        " convertErrorBody(throwable)"
                    )
                }
                is SocketTimeoutException -> ResultWrapper.Error(
                    ErrorStatus.TIMEOUT,
                    null,
                   " App.getInstance().getString(R.string.socket_timeout_exception)"
                )
                else -> ResultWrapper.Error(
                    ErrorStatus.NOT_DEFINED,
                    null,
                    throwable.message
                )
            }
        }
    }
}*/
