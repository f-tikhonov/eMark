package kz.sapasoft.emark.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;

import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.ui.custom_views.MarkerDepthView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerIdentifierView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerModelView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerPhotoView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerTypeView;
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
        super((Object) dataBindingComponent, view, 0, (AppBarLayout) objArr[1], (MaterialButton) objArr[10], (LinearLayout) objArr[9], (ProgressBar) objArr[2], (ScrollView) objArr[3], (MarkerDepthView) objArr[7], (MarkerIdentifierView) objArr[5], (MarkerModelView) objArr[6], (MarkerPhotoView) objArr[8], (MarkerTypeView) objArr[4]);
        this.mDirtyFlags = -1;
        this.ablToolbar.setTag((Object) null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
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
