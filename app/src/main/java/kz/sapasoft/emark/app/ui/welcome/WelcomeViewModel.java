package kz.sapasoft.emark.app.ui.welcome;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.lifecycle.MutableLiveData;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.core.BaseViewModel;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0010\u0010\rR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\n8FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\n8FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0018\u0010\r¨\u0006\u001f"}, d2 = {"Lkz/sapasoft/emark/app/ui/welcome/WelcomeViewModel;", "Lkz/sapasoft/emark/app/core/BaseViewModel;", "prefsImpl", "Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;", "context", "Landroid/content/Context;", "baseCloudRepository", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "(Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;Landroid/content/Context;Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;)V", "error", "Landroidx/lifecycle/MutableLiveData;", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "getError", "()Landroidx/lifecycle/MutableLiveData;", "error$delegate", "Lkotlin/Lazy;", "isRefreshing", "", "isRefreshing$delegate", "loginData", "getLoginData", "loginData$delegate", "server", "", "getServer", "server$delegate", "login", "", "username", "password", "verifyAvailableNetwork", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WelcomeViewModel.kt */
public final class WelcomeViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public BaseCloudRepository baseCloudRepository;
    private final Context context;
    private final Lazy error$delegate = LazyKt.lazy(WelcomeViewModel$error$2.INSTANCE);
    private final Lazy isRefreshing$delegate = LazyKt.lazy(WelcomeViewModel$isRefreshing$2.INSTANCE);
    private final Lazy loginData$delegate = LazyKt.lazy(WelcomeViewModel$loginData$2.INSTANCE);
    /* access modifiers changed from: private */
    public final PrefsImpl prefsImpl;
    private final Lazy server$delegate = LazyKt.lazy(WelcomeViewModel$server$2.INSTANCE);

    public final MutableLiveData<ResultWrapper.Error> getError() {
        return (MutableLiveData) this.error$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getLoginData() {
        return (MutableLiveData) this.loginData$delegate.getValue();
    }

    public final MutableLiveData<String> getServer() {
        return (MutableLiveData) this.server$delegate.getValue();
    }

    public final MutableLiveData<Boolean> isRefreshing() {
        return (MutableLiveData) this.isRefreshing$delegate.getValue();
    }

    @Inject
    public WelcomeViewModel(PrefsImpl prefsImpl2, Context context2, BaseCloudRepository baseCloudRepository2) {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository");
        this.prefsImpl = prefsImpl2;
        this.context = context2;
        this.baseCloudRepository = baseCloudRepository2;
        getServer().postValue(this.prefsImpl.getServer());
    }

    public final void login(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str3, "server");
        if (verifyAvailableNetwork()) {
            launchIO(new WelcomeViewModel$login$1(this, str3, str, str2, (Continuation) null));
        } else if (Intrinsics.areEqual((Object) str, (Object) this.prefsImpl.getUsername()) && Intrinsics.areEqual((Object) str2, (Object) this.prefsImpl.getPassword()) && Intrinsics.areEqual((Object) str3, (Object) this.prefsImpl.getServer())) {
            getLoginData().postValue(true);
        }
    }

    private final boolean verifyAvailableNetwork() {
        Object systemService = this.context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
