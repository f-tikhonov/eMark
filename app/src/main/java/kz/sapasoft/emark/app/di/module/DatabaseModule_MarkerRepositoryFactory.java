package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerDao;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository;

public final class DatabaseModule_MarkerRepositoryFactory implements Factory<MarkerRepository> {
    private final Provider<MarkerDao> markerDaoProvider;
    private final DatabaseModule module;

    public DatabaseModule_MarkerRepositoryFactory(DatabaseModule databaseModule, Provider<MarkerDao> provider) {
        this.module = databaseModule;
        this.markerDaoProvider = provider;
    }

    public MarkerRepository get() {
        return markerRepository(this.module, this.markerDaoProvider.get());
    }

    public static DatabaseModule_MarkerRepositoryFactory create(DatabaseModule databaseModule, Provider<MarkerDao> provider) {
        return new DatabaseModule_MarkerRepositoryFactory(databaseModule, provider);
    }

    public static MarkerRepository markerRepository(DatabaseModule databaseModule, MarkerDao markerDao) {
        return (MarkerRepository) Preconditions.checkNotNull(databaseModule.markerRepository(markerDao), "Cannot return null from a non-@Nullable @Provides method");
    }
}
