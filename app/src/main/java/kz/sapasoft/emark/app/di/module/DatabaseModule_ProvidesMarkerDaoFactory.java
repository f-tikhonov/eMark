package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerDao;

public final class DatabaseModule_ProvidesMarkerDaoFactory implements Factory<MarkerDao> {
    private final Provider<LocalDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvidesMarkerDaoFactory(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        this.module = databaseModule;
        this.databaseProvider = provider;
    }

    public MarkerDao get() {
        return providesMarkerDao(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvidesMarkerDaoFactory create(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        return new DatabaseModule_ProvidesMarkerDaoFactory(databaseModule, provider);
    }

    public static MarkerDao providesMarkerDao(DatabaseModule databaseModule, LocalDatabase localDatabase) {
        return (MarkerDao) Preconditions.checkNotNull(databaseModule.providesMarkerDao(localDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
