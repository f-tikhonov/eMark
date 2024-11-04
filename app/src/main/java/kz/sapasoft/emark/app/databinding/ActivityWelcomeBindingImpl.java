package kz.sapasoft.emark.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel;
import kz.ss.emark.R;

public class ActivityWelcomeBindingImpl extends ActivityWelcomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_app_name, 1);
        sViewsWithIds.put(R.id.tv_welcome, 2);
        sViewsWithIds.put(R.id.til_username, 3);
        sViewsWithIds.put(R.id.et_username, 4);
        sViewsWithIds.put(R.id.til_password, 5);
        sViewsWithIds.put(R.id.et_password, 6);
        sViewsWithIds.put(R.id.til_server, 7);
        sViewsWithIds.put(R.id.et_server, 8);
        sViewsWithIds.put(R.id.btn_start, 9);
    }

    public ActivityWelcomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityWelcomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[9], objArr[6], objArr[8], objArr[4], objArr[5], objArr[7], objArr[3], objArr[1], objArr[2], objArr[0]);
        this.mDirtyFlags = -1;
        this.viewParent.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (5 != i) {
            return false;
        }
        setModel((WelcomeViewModel) obj);
        return true;
    }

    public void setModel(WelcomeViewModel welcomeViewModel) {
        this.mModel = welcomeViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
