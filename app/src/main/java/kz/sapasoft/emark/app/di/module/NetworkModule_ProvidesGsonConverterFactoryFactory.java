package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkModule_ProvidesGsonConverterFactoryFactory implements Factory<GsonConverterFactory> {
    private final NetworkModule module;

    public NetworkModule_ProvidesGsonConverterFactoryFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    public GsonConverterFactory get() {
        return providesGsonConverterFactory(this.module);
    }

    public static NetworkModule_ProvidesGsonConverterFactoryFactory create(NetworkModule networkModule) {
        return new NetworkModule_ProvidesGsonConverterFactoryFactory(networkModule);
    }

    public static GsonConverterFactory providesGsonConverterFactory(NetworkModule networkModule) {
        return (GsonConverterFactory) Preconditions.checkNotNull(networkModule.providesGsonConverterFactory(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
