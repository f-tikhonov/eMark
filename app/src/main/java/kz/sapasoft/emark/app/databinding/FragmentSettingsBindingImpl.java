package kz.sapasoft.emark.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textview.MaterialTextView;
import kz.sapasoft.emark.app.ui.settings.SettingsViewModel;
import kz.ss.emark.R;

public class FragmentSettingsBindingImpl extends FragmentSettingsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final MaterialTextView mboundView3;
    private final ProgressBar mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_circle, 6);
        sViewsWithIds.put(R.id.sb_size, 7);
    }

    public FragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, objArr[1], objArr[4], objArr[6], objArr[7], objArr[2]);
        this.mDirtyFlags = -1;
        this.ablToolbar.setTag((Object) null);
        this.btnDownload.setTag((Object) null);
        ScrollView scrollView = objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag((Object) null);
        MaterialTextView materialTextView = objArr[3];
        this.mboundView3 = materialTextView;
        materialTextView.setTag((Object) null);
        ProgressBar progressBar = objArr[5];
        this.mboundView5 = progressBar;
        progressBar.setTag((Object) null);
        this.swOffline.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (6 != i) {
            return false;
        }
        setViewModel((SettingsViewModel) obj);
        return true;
    }

    public void setViewModel(SettingsViewModel settingsViewModel) {
        this.mViewModel = settingsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelProgress((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelDateDb((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return onChangeViewModelProgressVisibility((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return onChangeViewModelOfflineMode((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeViewModelLoadButtonEnabled((MutableLiveData) obj, i2);
    }

    private boolean onChangeViewModelProgress(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelDateDb(MutableLiveData<String> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelProgressVisibility(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelOfflineMode(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelLoadButtonEnabled(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0106 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0106 }
            monitor-exit(r26)     // Catch:{ all -> 0x0106 }
            kz.sapasoft.emark.app.ui.settings.SettingsViewModel r0 = r1.mViewModel
            r6 = 127(0x7f, double:6.27E-322)
            long r6 = r6 & r2
            r10 = 100
            r12 = 98
            r14 = 97
            r16 = 112(0x70, double:5.53E-322)
            r8 = 0
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00c8
            long r6 = r2 & r14
            int r20 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x003c
            if (r0 == 0) goto L_0x0029
            androidx.lifecycle.MutableLiveData r6 = r0.getProgress()
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            r1.updateLiveDataRegistration(r8, r6)
            if (r6 == 0) goto L_0x0036
            java.lang.Object r6 = r6.getValue()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r6)
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            long r20 = r2 & r12
            int r7 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0058
            if (r0 == 0) goto L_0x004a
            androidx.lifecycle.MutableLiveData r7 = r0.getDateDb()
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            r8 = 1
            r1.updateLiveDataRegistration(r8, r7)
            if (r7 == 0) goto L_0x0058
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0059
        L_0x0058:
            r7 = 0
        L_0x0059:
            long r21 = r2 & r10
            int r8 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x007a
            if (r0 == 0) goto L_0x0066
            androidx.lifecycle.MutableLiveData r8 = r0.getProgressVisibility()
            goto L_0x0067
        L_0x0066:
            r8 = 0
        L_0x0067:
            r9 = 2
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x0074
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x0075
        L_0x0074:
            r8 = 0
        L_0x0075:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            goto L_0x007b
        L_0x007a:
            r8 = 0
        L_0x007b:
            r18 = 104(0x68, double:5.14E-322)
            long r22 = r2 & r18
            int r9 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x009e
            if (r0 == 0) goto L_0x008a
            androidx.lifecycle.MutableLiveData r9 = r0.getOfflineMode()
            goto L_0x008b
        L_0x008a:
            r9 = 0
        L_0x008b:
            r14 = 3
            r1.updateLiveDataRegistration(r14, r9)
            if (r9 == 0) goto L_0x0098
            java.lang.Object r9 = r9.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x0099
        L_0x0098:
            r9 = 0
        L_0x0099:
            boolean r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            goto L_0x009f
        L_0x009e:
            r9 = 0
        L_0x009f:
            long r14 = r2 & r16
            int r24 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x00c5
            if (r0 == 0) goto L_0x00ac
            androidx.lifecycle.MutableLiveData r0 = r0.getLoadButtonEnabled()
            goto L_0x00ad
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            r14 = 4
            r1.updateLiveDataRegistration(r14, r0)
            if (r0 == 0) goto L_0x00ba
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x00bb
        L_0x00ba:
            r0 = 0
        L_0x00bb:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            r25 = r8
            r8 = r0
            r0 = r25
            goto L_0x00cd
        L_0x00c5:
            r0 = r8
            r8 = 0
            goto L_0x00cd
        L_0x00c8:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x00cd:
            long r14 = r2 & r16
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00d8
            com.google.android.material.button.MaterialButton r14 = r1.btnDownload
            r14.setEnabled(r8)
        L_0x00d8:
            long r12 = r12 & r2
            int r8 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00e2
            com.google.android.material.textview.MaterialTextView r8 = r1.mboundView3
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r8, r7)
        L_0x00e2:
            long r7 = r2 & r10
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00ed
            android.widget.ProgressBar r7 = r1.mboundView5
            kz.sapasoft.emark.app.ui.CustomBindingAdapterKt.visibilityBool(r7, r0)
        L_0x00ed:
            r7 = 97
            long r7 = r7 & r2
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f9
            android.widget.ProgressBar r0 = r1.mboundView5
            r0.setProgress(r6)
        L_0x00f9:
            r6 = 104(0x68, double:5.14E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0105
            com.google.android.material.switchmaterial.SwitchMaterial r0 = r1.swOffline
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r0, r9)
        L_0x0105:
            return
        L_0x0106:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x0106 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.databinding.FragmentSettingsBindingImpl.executeBindings():void");
    }
}
