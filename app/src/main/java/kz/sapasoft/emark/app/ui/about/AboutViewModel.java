package kz.sapasoft.emark.app.ui.about;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.core.BaseViewModel;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkz/sapasoft/emark/app/ui/about/AboutViewModel;", "Lkz/sapasoft/emark/app/core/BaseViewModel;", "prefsImpl", "Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;", "baseCloudRepository", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "(Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AboutViewModel.kt */
public final class AboutViewModel extends BaseViewModel {
    private final String TAG = getClass().getSimpleName();
    private final BaseCloudRepository baseCloudRepository;
    private final PrefsImpl prefsImpl;

    @Inject
    public AboutViewModel(PrefsImpl prefsImpl2, BaseCloudRepository baseCloudRepository2) {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl");
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository");
        this.prefsImpl = prefsImpl2;
        this.baseCloudRepository = baseCloudRepository2;
    }
}
