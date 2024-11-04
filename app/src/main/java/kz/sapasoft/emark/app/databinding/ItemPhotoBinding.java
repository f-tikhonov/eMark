package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.ss.emark.R;

public abstract class ItemPhotoBinding extends ViewDataBinding {
    public final ImageView ivDelete;
    public final ImageView ivPhoto;
    @Bindable
    protected ImageDataModel mImageDataModel;
    @Bindable
    protected Boolean mIsVisible;

    public abstract void setImageDataModel(ImageDataModel imageDataModel);

    public abstract void setIsVisible(Boolean bool);

    protected ItemPhotoBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.ivDelete = imageView;
        this.ivPhoto = imageView2;
    }

    public ImageDataModel getImageDataModel() {
        return this.mImageDataModel;
    }

    public Boolean getIsVisible() {
        return this.mIsVisible;
    }

    public static ItemPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_photo, viewGroup, z, obj);
    }

    public static ItemPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_photo, (ViewGroup) null, false, obj);
    }

    public static ItemPhotoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoBinding bind(View view, Object obj) {
        return (ItemPhotoBinding) bind(obj, view, R.layout.item_photo);
    }
}
