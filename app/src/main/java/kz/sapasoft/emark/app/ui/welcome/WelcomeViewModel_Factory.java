package kz.sapasoft.emark.app.ui.welcome;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;

public final class WelcomeViewModel_Factory implements Factory<WelcomeViewModel> {
    private final Provider<BaseCloudRepository> baseCloudRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<PrefsImpl> prefsImplProvider;

    public WelcomeViewModel_Factory(Provider<PrefsImpl> provider, Provider<Context> provider2, Provider<BaseCloudRepository> provider3) {
        this.prefsImplProvider = provider;
        this.contextProvider = provider2;
        this.baseCloudRepositoryProvider = provider3;
    }

    public WelcomeViewModel get() {
        return newInstance(this.prefsImplProvider.get(), this.contextProvider.get(), this.baseCloudRepositoryProvider.get());
    }

    public static WelcomeViewModel_Factory create(Provider<PrefsImpl> provider, Provider<Context> provider2, Provider<BaseCloudRepository> provider3) {
        return new WelcomeViewModel_Factory(provider, provider2, provider3);
    }

    public static WelcomeViewModel newInstance(PrefsImpl prefsImpl, Context context, BaseCloudRepository baseCloudRepository) {
        return new WelcomeViewModel(prefsImpl, context, baseCloudRepository);
    }
}
