package kz.sapasoft.emark.app.core

import android.util.Log
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
            Log.d("terra", "exceptionHandler ${throwable.localizedMessage}")
            throwable.printStackTrace()
        }

        viewModelScope.launch(exceptionHandler) {
            try {
                doOnAsyncBlock()
            } catch (e: CancellationException) {
                // Handle coroutine cancellation
                Log.d("terra", "CancellationException ${e.localizedMessage}")
                e.printStackTrace()
            } catch (e: Exception) {
                Log.d("terra", "Exception ${e.localizedMessage}")
                // Handle other exceptions
                e.printStackTrace()
            }
        }
    }
}