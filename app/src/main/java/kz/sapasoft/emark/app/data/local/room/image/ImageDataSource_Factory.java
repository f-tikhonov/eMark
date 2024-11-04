package kz.sapasoft.emark.app.data.local.room.image;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ImageDataSource_Factory implements Factory<ImageDataSource> {
    private final Provider<ImageDao> imageDaoProvider;

    public ImageDataSource_Factory(Provider<ImageDao> provider) {
        this.imageDaoProvider = provider;
    }

    public ImageDataSource get() {
        return newInstance(this.imageDaoProvider.get());
    }

    public static ImageDataSource_Factory create(Provider<ImageDao> provider) {
        return new ImageDataSource_Factory(provider);
    }

    public static ImageDataSource newInstance(ImageDao imageDao) {
        return new ImageDataSource(imageDao);
    }
}
