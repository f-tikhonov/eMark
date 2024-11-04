package kz.sapasoft.emark.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel;
import kz.ss.emark.R;

public abstract class ActivityWelcomeBinding extends ViewDataBinding {
    public final MaterialButton btnStart;
    public final TextInputEditText etPassword;
    public final TextInputEditText etServer;
    public final TextInputEditText etUsername;
    @Bindable
    protected WelcomeViewModel mModel;
    public final TextInputLayout tilPassword;
    public final TextInputLayout tilServer;
    public final TextInputLayout tilUsername;
    public final MaterialTextView tvAppName;
    public final MaterialTextView tvWelcome;
    public final ScrollView viewParent;

    public abstract void setModel(WelcomeViewModel welcomeViewModel);

    protected ActivityWelcomeBinding(Object obj, View view, int i, MaterialButton materialButton, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, MaterialTextView materialTextView, MaterialTextView materialTextView2, ScrollView scrollView) {
        super(obj, view, i);
        this.btnStart = materialButton;
        this.etPassword = textInputEditText;
        this.etServer = textInputEditText2;
        this.etUsername = textInputEditText3;
        this.tilPassword = textInputLayout;
        this.tilServer = textInputLayout2;
        this.tilUsername = textInputLayout3;
        this.tvAppName = materialTextView;
        this.tvWelcome = materialTextView2;
        this.viewParent = scrollView;
    }

    public WelcomeViewModel getModel() {
        return this.mModel;
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWelcomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_welcome, viewGroup, z, obj);
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWelcomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_welcome, (ViewGroup) null, false, obj);
    }

    public static ActivityWelcomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWelcomeBinding bind(View view, Object obj) {
        return (ActivityWelcomeBinding) bind(obj, view, R.layout.activity_welcome);
    }
}
