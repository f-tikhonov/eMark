package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncDao;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository;

public final class DatabaseModule_MarkerSyncRepositoryFactory implements Factory<MarkerSyncRepository> {
    private final Provider<MarkerSyncDao> markerSyncDaoProvider;
    private final DatabaseModule module;

    public DatabaseModule_MarkerSyncRepositoryFactory(DatabaseModule databaseModule, Provider<MarkerSyncDao> provider) {
        this.module = databaseModule;
        this.markerSyncDaoProvider = provider;
    }

    public MarkerSyncRepository get() {
        return markerSyncRepository(this.module, this.markerSyncDaoProvider.get());
    }

    public static DatabaseModule_MarkerSyncRepositoryFactory create(DatabaseModule databaseModule, Provider<MarkerSyncDao> provider) {
        return new DatabaseModule_MarkerSyncRepositoryFactory(databaseModule, provider);
    }

    public static MarkerSyncRepository markerSyncRepository(DatabaseModule databaseModule, MarkerSyncDao markerSyncDao) {
        return (MarkerSyncRepository) Preconditions.checkNotNull(databaseModule.markerSyncRepository(markerSyncDao), "Cannot return null from a non-@Nullable @Provides method");
    }
}
