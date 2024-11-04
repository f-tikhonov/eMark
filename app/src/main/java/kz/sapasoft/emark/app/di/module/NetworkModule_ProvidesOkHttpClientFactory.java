package kz.sapasoft.emark.app.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class NetworkModule_ProvidesOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<Context> contextProvider;
    private final NetworkModule module;

    public NetworkModule_ProvidesOkHttpClientFactory(NetworkModule networkModule, Provider<Context> provider) {
        this.module = networkModule;
        this.contextProvider = provider;
    }

    public OkHttpClient get() {
        return providesOkHttpClient(this.module, this.contextProvider.get());
    }

    public static NetworkModule_ProvidesOkHttpClientFactory create(NetworkModule networkModule, Provider<Context> provider) {
        return new NetworkModule_ProvidesOkHttpClientFactory(networkModule, provider);
    }

    public static OkHttpClient providesOkHttpClient(NetworkModule networkModule, Context context) {
        return (OkHttpClient) Preconditions.checkNotNull(networkModule.providesOkHttpClient(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
