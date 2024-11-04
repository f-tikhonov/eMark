package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncDao;

public final class DatabaseModule_ProvidesMarkerSyncDaoFactory implements Factory<MarkerSyncDao> {
    private final Provider<LocalDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvidesMarkerSyncDaoFactory(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        this.module = databaseModule;
        this.databaseProvider = provider;
    }

    public MarkerSyncDao get() {
        return providesMarkerSyncDao(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvidesMarkerSyncDaoFactory create(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        return new DatabaseModule_ProvidesMarkerSyncDaoFactory(databaseModule, provider);
    }

    public static MarkerSyncDao providesMarkerSyncDao(DatabaseModule databaseModule, LocalDatabase localDatabase) {
        return (MarkerSyncDao) Preconditions.checkNotNull(databaseModule.providesMarkerSyncDao(localDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
