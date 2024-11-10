package kz.sapasoft.emark.app.databinding;

import android.annotation.SuppressLint;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;

import com.google.android.material.appbar.AppBarLayout;

import org.osmdroid.views.MapView;

import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.ss.emark.R;

public class FragmentMapBindingImpl extends FragmentMapBinding {
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
        sparseIntArray.put(R.id.map_view, 3);
        sViewsWithIds.put(R.id.iv_pin, 4);
    }

    public FragmentMapBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private FragmentMapBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super((Object) dataBindingComponent, view, 0, (AppBarLayout) objArr[1], (ImageView) objArr[4], (MapView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.ablToolbar.setTag((Object) null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        this.tvName.setTag((Object) null);
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
        setItem((ProjectModel) obj);
        return true;
    }

    public void setItem(ProjectModel projectModel) {
        this.mItem = projectModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @SuppressLint("RestrictedApi")
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = null;
        ProjectModel projectModel = this.mItem;
        long j2 = j & 3;
        if (!(j2 == 0 || projectModel == null)) {
            str = projectModel.getName();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvName, str);
        }
    }
}
