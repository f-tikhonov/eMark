package kz.sapasoft.emark.app.databinding;

import android.annotation.SuppressLint;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.decompiledapk.R;
import com.google.android.material.appbar.AppBarLayout;

import kz.sapasoft.emark.app.ui.projects.ProjectsViewModel;

public class FragmentProjectsBindingImpl extends FragmentProjectsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener etSearchandroidTextAttrChanged;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rv_main_home, 4);
        sViewsWithIds.put(R.id.ll_connection_error, 5);
        sViewsWithIds.put(R.id.tv_connection_error, 6);
        sViewsWithIds.put(R.id.tv_retry, 7);
    }

    public FragmentProjectsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentProjectsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AppBarLayout) objArr[1], (EditText) objArr[2], (LinearLayout) objArr[5], (RecyclerView) objArr[4], (SwipeRefreshLayout) objArr[3], (TextView) objArr[6], (TextView) objArr[7]);
        this.etSearchandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                @SuppressLint("RestrictedApi") String textString = TextViewBindingAdapter.getTextString(FragmentProjectsBindingImpl.this.etSearch);
                ProjectsViewModel projectsViewModel = FragmentProjectsBindingImpl.this.mViewModel;
                boolean z = true;
                if (projectsViewModel != null) {
                    MutableLiveData<String> searchString = projectsViewModel.getSearchString();
                    if (searchString == null) {
                        z = false;
                    }
                    if (z) {
                        searchString.setValue(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.ablToolbar.setTag((Object) null);
        this.etSearch.setTag((Object) null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        this.swipe.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (6 != i) {
            return false;
        }
        setViewModel((ProjectsViewModel) obj);
        return true;
    }

    public void setViewModel(ProjectsViewModel projectsViewModel) {
        this.mViewModel = projectsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelSearchString((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModelIsRefreshing((MutableLiveData) obj, i2);
    }

    private boolean onChangeViewModelSearchString(MutableLiveData<String> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsRefreshing(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.mDirtyFlags     // Catch:{ all -> 0x007f }
            r2 = 0
            r15.mDirtyFlags = r2     // Catch:{ all -> 0x007f }
            monitor-exit(r15)     // Catch:{ all -> 0x007f }
            kz.sapasoft.emark.app.ui.projects.ProjectsViewModel r4 = r15.mViewModel
            r5 = 15
            long r5 = r5 & r0
            r7 = 14
            r9 = 13
            r11 = 0
            r12 = 0
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0053
            long r5 = r0 & r9
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0024
            androidx.lifecycle.MutableLiveData r5 = r4.getSearchString()
            goto L_0x0025
        L_0x0024:
            r5 = r12
        L_0x0025:
            r15.updateLiveDataRegistration(r11, r5)
            if (r5 == 0) goto L_0x0031
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0032
        L_0x0031:
            r5 = r12
        L_0x0032:
            long r13 = r0 & r7
            int r6 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0054
            if (r4 == 0) goto L_0x003f
            androidx.lifecycle.MutableLiveData r4 = r4.isRefreshing()
            goto L_0x0040
        L_0x003f:
            r4 = r12
        L_0x0040:
            r6 = 1
            r15.updateLiveDataRegistration(r6, r4)
            if (r4 == 0) goto L_0x004d
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x004e
        L_0x004d:
            r4 = r12
        L_0x004e:
            boolean r11 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            goto L_0x0054
        L_0x0053:
            r5 = r12
        L_0x0054:
            long r9 = r9 & r0
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x005e
            android.widget.EditText r4 = r15.etSearch
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r5)
        L_0x005e:
            r4 = 8
            long r4 = r4 & r0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0074
            android.widget.EditText r4 = r15.etSearch
            r5 = r12
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r5 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r5
            r6 = r12
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r6 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r6
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r12 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r12
            androidx.databinding.InverseBindingListener r9 = r15.etSearchandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r5, r6, r12, r9)
        L_0x0074:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x007e
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r15.swipe
            kz.sapasoft.emark.app.ui.CustomBindingAdapterKt.isRefreshing(r0, r11)
        L_0x007e:
            return
        L_0x007f:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x007f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.databinding.FragmentProjectsBindingImpl.executeBindings():void");
    }
}
