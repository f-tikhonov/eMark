package kz.sapasoft.emark.app.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.decompiledapk.R;
import com.google.android.material.appbar.AppBarLayout;
import kz.sapasoft.emark.app.ui.projects.ProjectsViewModel;

public abstract class FragmentProjectsBinding extends ViewDataBinding {
    public final AppBarLayout ablToolbar;
    public final EditText etSearch;
    public final LinearLayout llConnectionError;
    @Bindable
    protected ProjectsViewModel mViewModel;
    public final RecyclerView rvMainHome;
    public final SwipeRefreshLayout swipe;
    public final TextView tvConnectionError;
    public final TextView tvRetry;

    public abstract void setViewModel(ProjectsViewModel projectsViewModel);

    protected FragmentProjectsBinding(Object obj, View view, int i, AppBarLayout appBarLayout, EditText editText, LinearLayout linearLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ablToolbar = appBarLayout;
        this.etSearch = editText;
        this.llConnectionError = linearLayout;
        this.rvMainHome = recyclerView;
        this.swipe = swipeRefreshLayout;
        this.tvConnectionError = textView;
        this.tvRetry = textView2;
    }

    public ProjectsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentProjectsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    public static FragmentProjectsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentProjectsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_projects, viewGroup, z, obj);
    }

    public static FragmentProjectsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    public static FragmentProjectsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentProjectsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_projects, (ViewGroup) null, false, obj);
    }

    public static FragmentProjectsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProjectsBinding bind(View view, Object obj) {
        return (FragmentProjectsBinding) bind(obj, view, R.layout.fragment_projects);
    }
}
