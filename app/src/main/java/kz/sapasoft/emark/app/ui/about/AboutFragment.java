package kz.sapasoft.emark.app.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.DaggerFragment;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.databinding.FragmentAboutBinding;
import kz.sapasoft.emark.app.ui.MainActivity;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lkz/sapasoft/emark/app/ui/about/AboutFragment;", "Ldagger/android/support/DaggerFragment;", "()V", "TAG", "", "viewModel", "Lkz/sapasoft/emark/app/ui/about/AboutViewModel;", "getViewModel", "()Lkz/sapasoft/emark/app/ui/about/AboutViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setListeners", "setObservers", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AboutFragment.kt */
public final class AboutFragment extends DaggerFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String TAG;
    private HashMap _$_findViewCache;
    private final Lazy viewModel$delegate = LazyKt.lazy(new AboutFragment$viewModel$2(this));
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    private final AboutViewModel getViewModel() {
        return (AboutViewModel) this.viewModel$delegate.getValue();
    }

    private final void setListeners() {
    }

    private final void setObservers() {
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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public AboutFragment() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        this.TAG = simpleName;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lkz/sapasoft/emark/app/ui/about/AboutFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AboutFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fragment newInstance() {
            AboutFragment aboutFragment = new AboutFragment();
            aboutFragment.setArguments(new Bundle());
            return aboutFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentAboutBinding fragmentAboutBinding = (FragmentAboutBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_about, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentAboutBinding, "binding");
        return fragmentAboutBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        setObservers();
        setListeners();
    }

    private final void initView() {
        TextView textView = (TextView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.tv_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar");
        textView.setText(getString(R.string.nav_item_about));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).setSupportActionBar((Toolbar) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.toolbar));
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ActionBar supportActionBar = ((MainActivity) activity2).getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(false);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
        }
        throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
    }
}
