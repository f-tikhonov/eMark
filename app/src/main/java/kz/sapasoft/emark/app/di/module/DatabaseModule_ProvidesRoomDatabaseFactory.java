package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;

public final class DatabaseModule_ProvidesRoomDatabaseFactory implements Factory<LocalDatabase> {
    private final DatabaseModule module;

    public DatabaseModule_ProvidesRoomDatabaseFactory(DatabaseModule databaseModule) {
        this.module = databaseModule;
    }

    public LocalDatabase get() {
        return providesRoomDatabase(this.module);
    }

    public static DatabaseModule_ProvidesRoomDatabaseFactory create(DatabaseModule databaseModule) {
        return new DatabaseModule_ProvidesRoomDatabaseFactory(databaseModule);
    }

    public static LocalDatabase providesRoomDatabase(DatabaseModule databaseModule) {
        return (LocalDatabase) Preconditions.checkNotNull(databaseModule.providesRoomDatabase(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
