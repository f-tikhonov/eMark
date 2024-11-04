package kz.sapasoft.emark.app.ui.map;

import dagger.internal.Factory;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;

public final class MapViewModel_Factory implements Factory<MapViewModel> {
    private final Provider<BaseCloudRepository> baseCloudRepositoryProvider;
    private final Provider<ImageRepository> imageRepositoryProvider;
    private final Provider<MarkerRepository> markerRepositoryProvider;
    private final Provider<MarkerSyncRepository> markerSyncRepositoryProvider;
    private final Provider<PrefsImpl> prefsImplProvider;
    private final Provider<TemplateRepository> templateRepositoryProvider;

    public MapViewModel_Factory(Provider<BaseCloudRepository> provider, Provider<TemplateRepository> provider2, Provider<ImageRepository> provider3, Provider<MarkerRepository> provider4, Provider<MarkerSyncRepository> provider5, Provider<PrefsImpl> provider6) {
        this.baseCloudRepositoryProvider = provider;
        this.templateRepositoryProvider = provider2;
        this.imageRepositoryProvider = provider3;
        this.markerRepositoryProvider = provider4;
        this.markerSyncRepositoryProvider = provider5;
        this.prefsImplProvider = provider6;
    }

    public MapViewModel get() {
        return newInstance(this.baseCloudRepositoryProvider.get(), this.templateRepositoryProvider.get(), this.imageRepositoryProvider.get(), this.markerRepositoryProvider.get(), this.markerSyncRepositoryProvider.get(), this.prefsImplProvider.get());
    }

    public static MapViewModel_Factory create(Provider<BaseCloudRepository> provider, Provider<TemplateRepository> provider2, Provider<ImageRepository> provider3, Provider<MarkerRepository> provider4, Provider<MarkerSyncRepository> provider5, Provider<PrefsImpl> provider6) {
        return new MapViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static MapViewModel newInstance(BaseCloudRepository baseCloudRepository, TemplateRepository templateRepository, ImageRepository imageRepository, MarkerRepository markerRepository, MarkerSyncRepository markerSyncRepository, PrefsImpl prefsImpl) {
        return new MapViewModel(baseCloudRepository, templateRepository, imageRepository, markerRepository, markerSyncRepository, prefsImpl);
    }
}
