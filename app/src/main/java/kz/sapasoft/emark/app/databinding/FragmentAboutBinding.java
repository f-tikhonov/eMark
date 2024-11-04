package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import kz.sapasoft.emark.app.domain.model.AboutModel;
import kz.ss.emark.R;

public abstract class FragmentAboutBinding extends ViewDataBinding {
    public final AppBarLayout ablToolbar;
    @Bindable
    protected AboutModel mAbout;

    public abstract void setAbout(AboutModel aboutModel);

    protected FragmentAboutBinding(Object obj, View view, int i, AppBarLayout appBarLayout) {
        super(obj, view, i);
        this.ablToolbar = appBarLayout;
    }

    public AboutModel getAbout() {
        return this.mAbout;
    }

    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAboutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_about, viewGroup, z, obj);
    }

    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAboutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAboutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_about, (ViewGroup) null, false, obj);
    }

    public static FragmentAboutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAboutBinding bind(View view, Object obj) {
        return (FragmentAboutBinding) bind(obj, view, R.layout.fragment_about);
    }
}
