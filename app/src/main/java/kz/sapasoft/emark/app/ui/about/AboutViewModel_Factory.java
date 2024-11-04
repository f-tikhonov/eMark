package kz.sapasoft.emark.app.ui.about;

import dagger.internal.Factory;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;

public final class AboutViewModel_Factory implements Factory<AboutViewModel> {
    private final Provider<BaseCloudRepository> baseCloudRepositoryProvider;
    private final Provider<PrefsImpl> prefsImplProvider;

    public AboutViewModel_Factory(Provider<PrefsImpl> provider, Provider<BaseCloudRepository> provider2) {
        this.prefsImplProvider = provider;
        this.baseCloudRepositoryProvider = provider2;
    }

    public AboutViewModel get() {
        return newInstance(this.prefsImplProvider.get(), this.baseCloudRepositoryProvider.get());
    }

    public static AboutViewModel_Factory create(Provider<PrefsImpl> provider, Provider<BaseCloudRepository> provider2) {
        return new AboutViewModel_Factory(provider, provider2);
    }

    public static AboutViewModel newInstance(PrefsImpl prefsImpl, BaseCloudRepository baseCloudRepository) {
        return new AboutViewModel(prefsImpl, baseCloudRepository);
    }
}
