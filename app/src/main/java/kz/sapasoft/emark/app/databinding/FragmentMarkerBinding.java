package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
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

public abstract class FragmentMarkerBinding extends ViewDataBinding {
    public final AppBarLayout ablToolbar;
    public final MaterialButton btnSave;
    public final LinearLayout llAdditionalFields;
    @Bindable
    protected MarkerModel mItem;
    public final ProgressBar pbMain;
    public final ScrollView svMain;
    public final MarkerDepthView viewMarkerDepth;
    public final MarkerIdentifierView viewMarkerIdentifier;
    public final MarkerModelView viewMarkerModel;
    public final MarkerPhotoView viewMarkerPhoto;
    public final MarkerTypeView viewMarkerType;

    public abstract void setItem(MarkerModel markerModel);

    protected FragmentMarkerBinding(Object obj, View view, int i, AppBarLayout appBarLayout, MaterialButton materialButton, LinearLayout linearLayout, ProgressBar progressBar, ScrollView scrollView, MarkerDepthView markerDepthView, MarkerIdentifierView markerIdentifierView, MarkerModelView markerModelView, MarkerPhotoView markerPhotoView, MarkerTypeView markerTypeView) {
        super(obj, view, i);
        this.ablToolbar = appBarLayout;
        this.btnSave = materialButton;
        this.llAdditionalFields = linearLayout;
        this.pbMain = progressBar;
        this.svMain = scrollView;
        this.viewMarkerDepth = markerDepthView;
        this.viewMarkerIdentifier = markerIdentifierView;
        this.viewMarkerModel = markerModelView;
        this.viewMarkerPhoto = markerPhotoView;
        this.viewMarkerType = markerTypeView;
    }

    public MarkerModel getItem() {
        return this.mItem;
    }

    public static FragmentMarkerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMarkerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMarkerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_marker, viewGroup, z, obj);
    }

    public static FragmentMarkerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMarkerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMarkerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_marker, (ViewGroup) null, false, obj);
    }

    public static FragmentMarkerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMarkerBinding bind(View view, Object obj) {
        return (FragmentMarkerBinding) bind(obj, view, R.layout.fragment_marker);
    }
}
