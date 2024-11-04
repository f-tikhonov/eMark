package kz.sapasoft.emark.app.ui.base;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import dagger.android.support.DaggerFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.ui.main_fragments.OnChildFragmentClickListener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkz/sapasoft/emark/app/ui/base/DaggerFragmentExtended;", "Ldagger/android/support/DaggerFragment;", "()V", "childFragmentClickListener", "Lkz/sapasoft/emark/app/ui/main_fragments/OnChildFragmentClickListener;", "getChildFragmentClickListener", "()Lkz/sapasoft/emark/app/ui/main_fragments/OnChildFragmentClickListener;", "setChildFragmentClickListener", "(Lkz/sapasoft/emark/app/ui/main_fragments/OnChildFragmentClickListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DaggerFragmentExtended.kt */
public class DaggerFragmentExtended extends DaggerFragment {
    private HashMap _$_findViewCache;
    public OnChildFragmentClickListener childFragmentClickListener;

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

    public final OnChildFragmentClickListener getChildFragmentClickListener() {
        OnChildFragmentClickListener onChildFragmentClickListener = this.childFragmentClickListener;
        if (onChildFragmentClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childFragmentClickListener");
        }
        return onChildFragmentClickListener;
    }

    public final void setChildFragmentClickListener(OnChildFragmentClickListener onChildFragmentClickListener) {
        Intrinsics.checkParameterIsNotNull(onChildFragmentClickListener, "<set-?>");
        this.childFragmentClickListener = onChildFragmentClickListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.childFragmentClickListener = (OnChildFragmentClickListener) parentFragment;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.main_fragments.OnChildFragmentClickListener");
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}
