package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;
import kz.sapasoft.emark.app.data.local.room.project.ProjectDao;

public final class DatabaseModule_ProvidesProjectDaoFactory implements Factory<ProjectDao> {
    private final Provider<LocalDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvidesProjectDaoFactory(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        this.module = databaseModule;
        this.databaseProvider = provider;
    }

    public ProjectDao get() {
        return providesProjectDao(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvidesProjectDaoFactory create(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        return new DatabaseModule_ProvidesProjectDaoFactory(databaseModule, provider);
    }

    public static ProjectDao providesProjectDao(DatabaseModule databaseModule, LocalDatabase localDatabase) {
        return (ProjectDao) Preconditions.checkNotNull(databaseModule.providesProjectDao(localDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
