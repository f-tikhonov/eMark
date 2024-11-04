package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.ss.emark.R;
import org.osmdroid.views.MapView;

public abstract class FragmentMapBinding extends ViewDataBinding {
    public final AppBarLayout ablToolbar;
    public final ImageView ivPin;
    @Bindable
    protected ProjectModel mItem;
    public final MapView mapView;
    public final TextView tvName;

    public abstract void setItem(ProjectModel projectModel);

    protected FragmentMapBinding(Object obj, View view, int i, AppBarLayout appBarLayout, ImageView imageView, MapView mapView2, TextView textView) {
        super(obj, view, i);
        this.ablToolbar = appBarLayout;
        this.ivPin = imageView;
        this.mapView = mapView2;
        this.tvName = textView;
    }

    public ProjectModel getItem() {
        return this.mItem;
    }

    public static FragmentMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMapBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_map, viewGroup, z, obj);
    }

    public static FragmentMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMapBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMapBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_map, (ViewGroup) null, false, obj);
    }

    public static FragmentMapBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMapBinding bind(View view, Object obj) {
        return (FragmentMapBinding) bind(obj, view, R.layout.fragment_map);
    }
}
