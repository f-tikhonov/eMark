package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.image.ImageDao;
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository;

public final class DatabaseModule_ImageRepositoryFactory implements Factory<ImageRepository> {
    private final Provider<ImageDao> imageDaoProvider;
    private final DatabaseModule module;

    public DatabaseModule_ImageRepositoryFactory(DatabaseModule databaseModule, Provider<ImageDao> provider) {
        this.module = databaseModule;
        this.imageDaoProvider = provider;
    }

    public ImageRepository get() {
        return imageRepository(this.module, this.imageDaoProvider.get());
    }

    public static DatabaseModule_ImageRepositoryFactory create(DatabaseModule databaseModule, Provider<ImageDao> provider) {
        return new DatabaseModule_ImageRepositoryFactory(databaseModule, provider);
    }

    public static ImageRepository imageRepository(DatabaseModule databaseModule, ImageDao imageDao) {
        return (ImageRepository) Preconditions.checkNotNull(databaseModule.imageRepository(imageDao), "Cannot return null from a non-@Nullable @Provides method");
    }
}
