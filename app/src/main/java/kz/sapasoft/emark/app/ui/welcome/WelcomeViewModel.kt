package kz.sapasoft.emark.app.ui.welcome

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.MutableLiveData
import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.jvm.internal.Intrinsics
class WelcomeViewModel @Inject constructor(
    prefsImpl2: PrefsImpl,
    context2: Context,
    baseCloudRepository2: BaseCloudRepository
) : BaseViewModel() {
    /* access modifiers changed from: private */
    @JvmField
    var baseCloudRepository: BaseCloudRepository
    private val context: Context
    private val `error$delegate`: MutableLiveData<ResultWrapper.Error> by lazy {
        MutableLiveData<ResultWrapper.Error>()
    }
    private val `isRefreshing$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    private val `loginData$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /* access modifiers changed from: private */
    @JvmField
    val prefsImpl: PrefsImpl
    private val `server$delegate`: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val error: MutableLiveData<ResultWrapper.Error>
        get() = `error$delegate`.value as MutableLiveData<ResultWrapper.Error>
    val loginData: MutableLiveData<Boolean>
        get() = `loginData$delegate`.value as MutableLiveData<Boolean>
    val server: MutableLiveData<String>
        get() = `server$delegate`.value as MutableLiveData<String>
    val isRefreshing: MutableLiveData<Boolean>
        get() = `isRefreshing$delegate`.value as MutableLiveData<Boolean>

    init {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl")
        Intrinsics.checkParameterIsNotNull(context2, "context")
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository")
        prefsImpl = prefsImpl2
        context = context2
        baseCloudRepository = baseCloudRepository2
        server.postValue(prefsImpl.server)
    }

    fun login(str: String?, str2: String?, str3: String?) {
        Intrinsics.checkParameterIsNotNull(str, "username")
        Intrinsics.checkParameterIsNotNull(str2, "password")
        Intrinsics.checkParameterIsNotNull(str3, "server")
        if (verifyAvailableNetwork()) {
            launchIO(`WelcomeViewModel$login$1`(this, str3, str, str2, null as Continuation<*>?))
        } else if (Intrinsics.areEqual(
                str as Any?,
                prefsImpl.username as Any
            ) && Intrinsics.areEqual(
                str2 as Any?,
                prefsImpl.password as Any
            ) && Intrinsics.areEqual(str3 as Any?, prefsImpl.server as Any)
        ) {
            loginData.postValue(true)
        }
    }

    private fun verifyAvailableNetwork(): Boolean {
        val systemService = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        if (systemService != null) {
            val activeNetworkInfo: NetworkInfo =
                (systemService as ConnectivityManager).getActiveNetworkInfo()!!
            return activeNetworkInfo != null && activeNetworkInfo.isConnected()
        }
        throw TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager")
    }
}
