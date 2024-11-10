package kz.sapasoft.emark.app.ui.welcome

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.MutableLiveData
import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.core.Config
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

    private val `server$delegate`: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val error: MutableLiveData<ResultWrapper.Error>
        get() = `error$delegate`
    val loginData: MutableLiveData<Boolean>
        get() = `loginData$delegate`
    val server: MutableLiveData<String?>
        get() = `server$delegate`
    val isRefreshing: MutableLiveData<Boolean>
        get() = `isRefreshing$delegate`

    init {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl")
        Intrinsics.checkParameterIsNotNull(context2, "context")
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository")
        prefsImpl = prefsImpl2
        context = context2
        baseCloudRepository = baseCloudRepository2
        server.postValue(prefsImpl.server)
    }

    fun login(username: String?, password: String?, server: String?) {
        requireNotNull(username) { "username" }
        requireNotNull(password) { "password" }
        requireNotNull(server) { "server" }

        if (verifyAvailableNetwork()) {
            launchIO {
                isRefreshing.postValue(true)
                val result = baseCloudRepository.login("$server/service/auth/login", username, password)

                when (result) {
                    is ResultWrapper.Error -> error.postValue(result)
                    is ResultWrapper.Success -> {
                        Config.DOMAIN = "$server/service/"
                        prefsImpl.apply {
                            this.username=(username)
                            this.password = (password)
                            this.server = (server)
                        }
                        loginData.postValue(true)
                    }
                }
                isRefreshing.postValue(false)
            }
        } else if (username == prefsImpl.username && password == prefsImpl.password && server == prefsImpl.server) {
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
