package kz.sapasoft.emark.app.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.cancellation.CancellationException
import kotlin.jvm.functions.Function2
import kotlin.jvm.internal.Intrinsics

abstract class BaseViewModel : ViewModel() {

    fun <P> launchIO(doOnAsyncBlock: suspend CoroutineScope.() -> P) {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            // Handle exception (log, report, etc.)
            throwable.printStackTrace()
        }

        viewModelScope.launch(exceptionHandler) {
            try {
                doOnAsyncBlock()
            } catch (e: CancellationException) {
                // Handle coroutine cancellation
                e.printStackTrace()
            } catch (e: Exception) {
                // Handle other exceptions
                e.printStackTrace()
            }
        }
    }
}