package kz.sapasoft.emark.app.ui.welcome;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.button.MaterialButton;
import dagger.android.support.DaggerAppCompatActivity;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lkz/sapasoft/emark/app/ui/welcome/WelcomeActivity;", "Ldagger/android/support/DaggerAppCompatActivity;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "viewModel", "Lkz/sapasoft/emark/app/ui/welcome/WelcomeViewModel;", "getViewModel", "()Lkz/sapasoft/emark/app/ui/welcome/WelcomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setObservers", "setOnClickListeners", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WelcomeActivity.kt */
public final class WelcomeActivity extends DaggerAppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private HashMap _$_findViewCache;
    private final Lazy viewModel$delegate = LazyKt.lazy(new WelcomeActivity$viewModel$2(this));
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    /* access modifiers changed from: private */
    public final WelcomeViewModel getViewModel() {
        return (WelcomeViewModel) this.viewModel$delegate.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_welcome);
        setOnClickListeners();
        setObservers();
    }

    private final void setOnClickListeners() {
        ((MaterialButton) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.btn_start)).setOnClickListener(new WelcomeActivity$setOnClickListeners$1(this));
    }

    private final void setObservers() {
        LifecycleOwner lifecycleOwner = this;
        getViewModel().isRefreshing().observe(lifecycleOwner, new WelcomeActivity$setObservers$1(this));
        getViewModel().getLoginData().observe(lifecycleOwner, new WelcomeActivity$setObservers$2(this));
        getViewModel().getError().observe(lifecycleOwner, new WelcomeActivity$setObservers$3(this));
        getViewModel().getServer().observe(lifecycleOwner, new WelcomeActivity$setObservers$4(this));
    }
}
