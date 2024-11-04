package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.rest.ApiService;
import retrofit2.Retrofit;

public final class NetworkModule_ProvideServiceFactory implements Factory<ApiService> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideServiceFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    public ApiService get() {
        return provideService(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideServiceFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideServiceFactory(networkModule, provider);
    }

    public static ApiService provideService(NetworkModule networkModule, Retrofit retrofit) {
        return (ApiService) Preconditions.checkNotNull(networkModule.provideService(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
