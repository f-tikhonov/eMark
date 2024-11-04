package kz.sapasoft.emark.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.ss.emark.R;

public class FragmentMarkerBindingImpl extends FragmentMarkerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.pb_main, 2);
        sViewsWithIds.put(R.id.sv_main, 3);
        sViewsWithIds.put(R.id.view_marker_type, 4);
        sViewsWithIds.put(R.id.view_marker_identifier, 5);
        sViewsWithIds.put(R.id.view_marker_model, 6);
        sViewsWithIds.put(R.id.view_marker_depth, 7);
        sViewsWithIds.put(R.id.view_marker_photo, 8);
        sViewsWithIds.put(R.id.ll_additional_fields, 9);
        sViewsWithIds.put(R.id.btn_save, 10);
    }

    public FragmentMarkerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentMarkerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[10], objArr[9], objArr[2], objArr[3], objArr[7], objArr[5], objArr[6], objArr[8], objArr[4]);
        this.mDirtyFlags = -1;
        this.ablToolbar.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
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
        if (4 != i) {
            return false;
        }
        setItem((MarkerModel) obj);
        return true;
    }

    public void setItem(MarkerModel markerModel) {
        this.mItem = markerModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
