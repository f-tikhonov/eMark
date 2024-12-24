package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.decompiledapk.R;

public abstract class ItemPhotoFooterBinding extends ViewDataBinding {
    public final ImageView ivFooter;

    protected ItemPhotoFooterBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.ivFooter = imageView;
    }

    public static ItemPhotoFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPhotoFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_photo_footer, viewGroup, z, obj);
    }

    public static ItemPhotoFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoFooterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPhotoFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_photo_footer, (ViewGroup) null, false, obj);
    }

    public static ItemPhotoFooterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoFooterBinding bind(View view, Object obj) {
        return (ItemPhotoFooterBinding) bind(obj, view, R.layout.item_photo_footer);
    }
}
