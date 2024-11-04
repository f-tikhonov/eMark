package kz.sapasoft.emark.app.ui.photo;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;

public final class PhotoViewModel_Factory implements Factory<PhotoViewModel> {
    private final Provider<BaseCloudRepository> baseCloudRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<PrefsImpl> prefsImplProvider;

    public PhotoViewModel_Factory(Provider<PrefsImpl> provider, Provider<Context> provider2, Provider<BaseCloudRepository> provider3) {
        this.prefsImplProvider = provider;
        this.contextProvider = provider2;
        this.baseCloudRepositoryProvider = provider3;
    }

    public PhotoViewModel get() {
        return newInstance(this.prefsImplProvider.get(), this.contextProvider.get(), this.baseCloudRepositoryProvider.get());
    }

    public static PhotoViewModel_Factory create(Provider<PrefsImpl> provider, Provider<Context> provider2, Provider<BaseCloudRepository> provider3) {
        return new PhotoViewModel_Factory(provider, provider2, provider3);
    }

    public static PhotoViewModel newInstance(PrefsImpl prefsImpl, Context context, BaseCloudRepository baseCloudRepository) {
        return new PhotoViewModel(prefsImpl, context, baseCloudRepository);
    }
}
