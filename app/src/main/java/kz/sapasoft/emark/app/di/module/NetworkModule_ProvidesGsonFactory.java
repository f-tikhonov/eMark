package kz.sapasoft.emark.app.di.module;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NetworkModule_ProvidesGsonFactory implements Factory<Gson> {
    private final NetworkModule module;

    public NetworkModule_ProvidesGsonFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    public Gson get() {
        return providesGson(this.module);
    }

    public static NetworkModule_ProvidesGsonFactory create(NetworkModule networkModule) {
        return new NetworkModule_ProvidesGsonFactory(networkModule);
    }

    public static Gson providesGson(NetworkModule networkModule) {
        return (Gson) Preconditions.checkNotNull(networkModule.providesGson(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
