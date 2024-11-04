package kz.sapasoft.emark.app.ui.main_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.ui.MainActivity;
import kz.sapasoft.emark.app.ui.about.AboutFragment;
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended;
import kz.sapasoft.emark.app.ui.projects.ProjectsFragment;
import kz.sapasoft.emark.app.ui.settings.SettingsFragment;
import kz.sapasoft.emark.app.utils.Utils;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkz/sapasoft/emark/app/ui/main_fragments/MainFragment;", "Lkz/sapasoft/emark/app/ui/base/DaggerFragmentExtended;", "Lkz/sapasoft/emark/app/ui/main_fragments/OnChildFragmentClickListener;", "()V", "TAG", "", "fragmentId", "", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentAdd", "fragment", "Landroidx/fragment/app/Fragment;", "onViewCreated", "view", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainFragment.kt */
public final class MainFragment extends DaggerFragmentExtended implements OnChildFragmentClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FRAGMENT_1 = 1;
    public static final int FRAGMENT_2 = 2;
    public static final int FRAGMENT_3 = 3;
    private final String TAG;
    private HashMap _$_findViewCache;
    private int fragmentId;

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

    public MainFragment() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        this.TAG = simpleName;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkz/sapasoft/emark/app/ui/main_fragments/MainFragment$Companion;", "", "()V", "FRAGMENT_1", "", "FRAGMENT_2", "FRAGMENT_3", "newInstance", "Landroidx/fragment/app/Fragment;", "id", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MainFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fragment newInstance(int i) {
            MainFragment mainFragment = new MainFragment();
            mainFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("id", Integer.valueOf(i))));
            return mainFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        this.fragmentId = requireArguments().getInt("id");
        return layoutInflater.inflate(R.layout.fragment_main, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Fragment fragment;
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        int i = this.fragmentId;
        if (i == 1) {
            fragment = ProjectsFragment.Companion.newInstance();
        } else if (i == 2) {
            fragment = SettingsFragment.Companion.newInstance();
        } else if (i != 3) {
            fragment = ProjectsFragment.Companion.newInstance();
        } else {
            fragment = AboutFragment.Companion.newInstance();
        }
        onFragmentAdd(fragment);
    }

    public void onFragmentAdd(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        Utils utils = Utils.INSTANCE;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.fl_content);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "fl_content");
        utils.hideKeyboard(frameLayout);
        getChildFragmentManager().beginTransaction().add((int) R.id.fl_content, fragment).addToBackStack(fragment.getTag()).commit();
    }

    public void onBackPressed() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        if (childFragmentManager.getFragments().size() == 1) {
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(childFragmentManager2, "childFragmentManager");
            if (childFragmentManager2.getFragments().get(0) instanceof ProjectsFragment) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    ((MainActivity) activity).setCloseActivityFlag();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
                }
            } else {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((MainActivity) activity2).openProjectsFragment();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
                }
            }
        }
        getChildFragmentManager().popBackStack();
    }
}
