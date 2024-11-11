package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.decompiledapk.R;

import kz.sapasoft.emark.app.domain.model.ProjectModel;

public abstract class ItemProjectBinding extends ViewDataBinding {
    @Bindable
    protected ProjectModel mItem;
    public final TextView tvName;
    public final TextView tvYear;

    public abstract void setItem(ProjectModel projectModel);

    protected ItemProjectBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvName = textView;
        this.tvYear = textView2;
    }

    public ProjectModel getItem() {
        return this.mItem;
    }

    public static ItemProjectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProjectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProjectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_project, viewGroup, z, obj);
    }

    public static ItemProjectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProjectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProjectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_project, (ViewGroup) null, false, obj);
    }

    public static ItemProjectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProjectBinding bind(View view, Object obj) {
        return (ItemProjectBinding) bind(obj, view, R.layout.item_project);
    }
}
