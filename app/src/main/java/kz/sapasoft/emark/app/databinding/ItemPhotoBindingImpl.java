package kz.sapasoft.emark.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

import java.io.UnsupportedEncodingException;

import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.ui.CustomBindingAdapterKt;

public class ItemPhotoBindingImpl extends ItemPhotoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemPhotoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemPhotoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (ImageView) objArr[1]);
        this.mDirtyFlags = -1;
        this.ivDelete.setTag((Object) null);
        this.ivPhoto.setTag((Object) null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (3 == i) {
            setIsVisible((Boolean) obj);
        } else if (2 != i) {
            return false;
        } else {
            setImageDataModel((ImageDataModel) obj);
        }
        return true;
    }

    public void setIsVisible(Boolean bool) {
        this.mIsVisible = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    public void setImageDataModel(ImageDataModel imageDataModel) {
        this.mImageDataModel = imageDataModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean bool = this.mIsVisible;
        boolean z = false;
        ImageDataModel imageDataModel = this.mImageDataModel;
        long j2 = 5 & j;
        if (j2 != 0) {
            z = ViewDataBinding.safeUnbox(bool);
        }
        long j3 = j & 6;
        if (j2 != 0) {
            CustomBindingAdapterKt.visibilityBool(this.ivDelete, z);
        }
        if (j3 != 0) {
            try {
                CustomBindingAdapterKt.loadImage(this.ivPhoto, imageDataModel);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
