package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkModule_ProvidesRetrofitFactory implements Factory<Retrofit> {
    private final Provider<GsonConverterFactory> gsonConverterFactoryProvider;
    private final NetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public NetworkModule_ProvidesRetrofitFactory(NetworkModule networkModule, Provider<GsonConverterFactory> provider, Provider<OkHttpClient> provider2) {
        this.module = networkModule;
        this.gsonConverterFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
    }

    public Retrofit get() {
        return providesRetrofit(this.module, this.gsonConverterFactoryProvider.get(), this.okHttpClientProvider.get());
    }

    public static NetworkModule_ProvidesRetrofitFactory create(NetworkModule networkModule, Provider<GsonConverterFactory> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_ProvidesRetrofitFactory(networkModule, provider, provider2);
    }

    public static Retrofit providesRetrofit(NetworkModule networkModule, GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient) {
        return (Retrofit) Preconditions.checkNotNull(networkModule.providesRetrofit(gsonConverterFactory, okHttpClient), "Cannot return null from a non-@Nullable @Provides method");
    }
}
