package kz.sapasoft.emark.app.ui.marker;

import dagger.internal.Factory;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;

public final class MarkerViewModel_Factory implements Factory<MarkerViewModel> {
    private final Provider<BaseCloudRepository> baseCloudRepositoryProvider;
    private final Provider<ImageRepository> imageRepositoryProvider;
    private final Provider<MarkerSyncRepository> markerSyncRepositoryProvider;
    private final Provider<PrefsImpl> prefsImplProvider;
    private final Provider<TagRepository> tagRepositoryProvider;
    private final Provider<TemplateRepository> templateRepositoryProvider;

    public MarkerViewModel_Factory(Provider<BaseCloudRepository> provider, Provider<PrefsImpl> provider2, Provider<TemplateRepository> provider3, Provider<ImageRepository> provider4, Provider<MarkerSyncRepository> provider5, Provider<TagRepository> provider6) {
        this.baseCloudRepositoryProvider = provider;
        this.prefsImplProvider = provider2;
        this.templateRepositoryProvider = provider3;
        this.imageRepositoryProvider = provider4;
        this.markerSyncRepositoryProvider = provider5;
        this.tagRepositoryProvider = provider6;
    }

    public MarkerViewModel get() {
        return newInstance(this.baseCloudRepositoryProvider.get(), this.prefsImplProvider.get(), this.templateRepositoryProvider.get(), this.imageRepositoryProvider.get(), this.markerSyncRepositoryProvider.get(), this.tagRepositoryProvider.get());
    }

    public static MarkerViewModel_Factory create(Provider<BaseCloudRepository> provider, Provider<PrefsImpl> provider2, Provider<TemplateRepository> provider3, Provider<ImageRepository> provider4, Provider<MarkerSyncRepository> provider5, Provider<TagRepository> provider6) {
        return new MarkerViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static MarkerViewModel newInstance(BaseCloudRepository baseCloudRepository, PrefsImpl prefsImpl, TemplateRepository templateRepository, ImageRepository imageRepository, MarkerSyncRepository markerSyncRepository, TagRepository tagRepository) {
        return new MarkerViewModel(baseCloudRepository, prefsImpl, templateRepository, imageRepository, markerSyncRepository, tagRepository);
    }
}
