package kz.sapasoft.emark.app.ui.projects;

import dagger.internal.Factory;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;

public final class ProjectsViewModel_Factory implements Factory<ProjectsViewModel> {
    private final Provider<BaseCloudRepository> baseCloudRepositoryProvider;
    private final Provider<PrefsImpl> prefsImplProvider;
    private final Provider<ProjectRepository> projectRepositoryProvider;
    private final Provider<TagRepository> tagRepositoryProvider;

    public ProjectsViewModel_Factory(Provider<PrefsImpl> provider, Provider<BaseCloudRepository> provider2, Provider<ProjectRepository> provider3, Provider<TagRepository> provider4) {
        this.prefsImplProvider = provider;
        this.baseCloudRepositoryProvider = provider2;
        this.projectRepositoryProvider = provider3;
        this.tagRepositoryProvider = provider4;
    }

    public ProjectsViewModel get() {
        return newInstance(this.prefsImplProvider.get(), this.baseCloudRepositoryProvider.get(), this.projectRepositoryProvider.get(), this.tagRepositoryProvider.get());
    }

    public static ProjectsViewModel_Factory create(Provider<PrefsImpl> provider, Provider<BaseCloudRepository> provider2, Provider<ProjectRepository> provider3, Provider<TagRepository> provider4) {
        return new ProjectsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static ProjectsViewModel newInstance(PrefsImpl prefsImpl, BaseCloudRepository baseCloudRepository, ProjectRepository projectRepository, TagRepository tagRepository) {
        return new ProjectsViewModel(prefsImpl, baseCloudRepository, projectRepository, tagRepository);
    }
}
