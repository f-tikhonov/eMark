package kz.sapasoft.emark.app.data.local.room.project;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProjectDataSource_Factory implements Factory<ProjectDataSource> {
    private final Provider<ProjectDao> projectDaoProvider;

    public ProjectDataSource_Factory(Provider<ProjectDao> provider) {
        this.projectDaoProvider = provider;
    }

    public ProjectDataSource get() {
        return newInstance(this.projectDaoProvider.get());
    }

    public static ProjectDataSource_Factory create(Provider<ProjectDao> provider) {
        return new ProjectDataSource_Factory(provider);
    }

    public static ProjectDataSource newInstance(ProjectDao projectDao) {
        return new ProjectDataSource(projectDao);
    }
}
