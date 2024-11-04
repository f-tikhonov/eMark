package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kz.sapasoft.emark.app.ui.projects.ProjectsViewModel;
import kz.ss.emark.R;

public abstract class FragmentMainBinding extends ViewDataBinding {
    public final FrameLayout flContent;
    @Bindable
    protected ProjectsViewModel mViewModel;

    public abstract void setViewModel(ProjectsViewModel projectsViewModel);

    protected FragmentMainBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.flContent = frameLayout;
    }

    public ProjectsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_main, viewGroup, z, obj);
    }

    public static FragmentMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_main, (ViewGroup) null, false, obj);
    }

    public static FragmentMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMainBinding bind(View view, Object obj) {
        return (FragmentMainBinding) bind(obj, view, R.layout.fragment_main);
    }
}
