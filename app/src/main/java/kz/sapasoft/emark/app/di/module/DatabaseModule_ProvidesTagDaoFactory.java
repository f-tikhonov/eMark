package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;
import kz.sapasoft.emark.app.data.local.room.tag.TagDao;

public final class DatabaseModule_ProvidesTagDaoFactory implements Factory<TagDao> {
    private final Provider<LocalDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvidesTagDaoFactory(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        this.module = databaseModule;
        this.databaseProvider = provider;
    }

    public TagDao get() {
        return providesTagDao(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvidesTagDaoFactory create(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        return new DatabaseModule_ProvidesTagDaoFactory(databaseModule, provider);
    }

    public static TagDao providesTagDao(DatabaseModule databaseModule, LocalDatabase localDatabase) {
        return (TagDao) Preconditions.checkNotNull(databaseModule.providesTagDao(localDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
