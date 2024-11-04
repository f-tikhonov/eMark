package kz.sapasoft.emark.app.ui.settings;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository;
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;

public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
    private final Provider<BaseCloudRepository> baseCloudRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<MarkerRepository> markerRepositoryProvider;
    private final Provider<PrefsImpl> prefsImplProvider;
    private final Provider<ProjectRepository> projectRepositoryProvider;
    private final Provider<TagRepository> tagRepositoryProvider;
    private final Provider<TemplateRepository> templateRepositoryProvider;

    public SettingsViewModel_Factory(Provider<PrefsImpl> provider, Provider<Context> provider2, Provider<BaseCloudRepository> provider3, Provider<ProjectRepository> provider4, Provider<TagRepository> provider5, Provider<TemplateRepository> provider6, Provider<MarkerRepository> provider7) {
        this.prefsImplProvider = provider;
        this.contextProvider = provider2;
        this.baseCloudRepositoryProvider = provider3;
        this.projectRepositoryProvider = provider4;
        this.tagRepositoryProvider = provider5;
        this.templateRepositoryProvider = provider6;
        this.markerRepositoryProvider = provider7;
    }

    public SettingsViewModel get() {
        return newInstance(this.prefsImplProvider.get(), this.contextProvider.get(), this.baseCloudRepositoryProvider.get(), this.projectRepositoryProvider.get(), this.tagRepositoryProvider.get(), this.templateRepositoryProvider.get(), this.markerRepositoryProvider.get());
    }

    public static SettingsViewModel_Factory create(Provider<PrefsImpl> provider, Provider<Context> provider2, Provider<BaseCloudRepository> provider3, Provider<ProjectRepository> provider4, Provider<TagRepository> provider5, Provider<TemplateRepository> provider6, Provider<MarkerRepository> provider7) {
        return new SettingsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SettingsViewModel newInstance(PrefsImpl prefsImpl, Context context, BaseCloudRepository baseCloudRepository, ProjectRepository projectRepository, TagRepository tagRepository, TemplateRepository templateRepository, MarkerRepository markerRepository) {
        return new SettingsViewModel(prefsImpl, context, baseCloudRepository, projectRepository, tagRepository, templateRepository, markerRepository);
    }
}
