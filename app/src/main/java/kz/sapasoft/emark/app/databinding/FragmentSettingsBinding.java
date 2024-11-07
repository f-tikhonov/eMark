package kz.sapasoft.emark.app.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kz.sapasoft.emark.app.ui.settings.SettingsViewModel;
import kz.ss.emark.R;

public abstract class FragmentSettingsBinding extends ViewDataBinding {
    public final AppBarLayout ablToolbar;
    public final MaterialButton btnDownload;
    public final ImageView ivCircle;
    @Bindable
    protected SettingsViewModel mViewModel;
    public final SeekBar sbSize;
    public final SwitchMaterial swOffline;

    public abstract void setViewModel(SettingsViewModel settingsViewModel);

    protected FragmentSettingsBinding(Object obj, View view, int i, AppBarLayout appBarLayout, MaterialButton materialButton, ImageView imageView, SeekBar seekBar, SwitchMaterial switchMaterial) {
        super(obj, view, i);
        this.ablToolbar = appBarLayout;
        this.btnDownload = materialButton;
        this.ivCircle = imageView;
        this.sbSize = seekBar;
        this.swOffline = switchMaterial;
    }

    public SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_settings, viewGroup, z, obj);
    }

    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    public static FragmentSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_settings, (ViewGroup) null, false, obj);
    }

    public static FragmentSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBinding bind(View view, Object obj) {
        return (FragmentSettingsBinding) bind(obj, view, R.layout.fragment_settings);
    }
}
