package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;
import kz.sapasoft.emark.app.data.local.room.image.ImageDao;

public final class DatabaseModule_ProvidesImageDaoFactory implements Factory<ImageDao> {
    private final Provider<LocalDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvidesImageDaoFactory(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        this.module = databaseModule;
        this.databaseProvider = provider;
    }

    public ImageDao get() {
        return providesImageDao(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvidesImageDaoFactory create(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        return new DatabaseModule_ProvidesImageDaoFactory(databaseModule, provider);
    }

    public static ImageDao providesImageDao(DatabaseModule databaseModule, LocalDatabase localDatabase) {
        return (ImageDao) Preconditions.checkNotNull(databaseModule.providesImageDao(localDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
