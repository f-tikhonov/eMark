package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.project.ProjectDao;
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository;

public final class DatabaseModule_ProjectRepositoryFactory implements Factory<ProjectRepository> {
    private final DatabaseModule module;
    private final Provider<ProjectDao> projectDaoProvider;

    public DatabaseModule_ProjectRepositoryFactory(DatabaseModule databaseModule, Provider<ProjectDao> provider) {
        this.module = databaseModule;
        this.projectDaoProvider = provider;
    }

    public ProjectRepository get() {
        return projectRepository(this.module, this.projectDaoProvider.get());
    }

    public static DatabaseModule_ProjectRepositoryFactory create(DatabaseModule databaseModule, Provider<ProjectDao> provider) {
        return new DatabaseModule_ProjectRepositoryFactory(databaseModule, provider);
    }

    public static ProjectRepository projectRepository(DatabaseModule databaseModule, ProjectDao projectDao) {
        return (ProjectRepository) Preconditions.checkNotNull(databaseModule.projectRepository(projectDao), "Cannot return null from a non-@Nullable @Provides method");
    }
}
