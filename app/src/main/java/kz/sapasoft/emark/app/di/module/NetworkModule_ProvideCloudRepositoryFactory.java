package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.cloud.rest.ApiService;

public final class NetworkModule_ProvideCloudRepositoryFactory implements Factory<BaseCloudRepository> {
    private final Provider<ApiService> apIsProvider;
    private final NetworkModule module;

    public NetworkModule_ProvideCloudRepositoryFactory(NetworkModule networkModule, Provider<ApiService> provider) {
        this.module = networkModule;
        this.apIsProvider = provider;
    }

    public BaseCloudRepository get() {
        return provideCloudRepository(this.module, this.apIsProvider.get());
    }

    public static NetworkModule_ProvideCloudRepositoryFactory create(NetworkModule networkModule, Provider<ApiService> provider) {
        return new NetworkModule_ProvideCloudRepositoryFactory(networkModule, provider);
    }

    public static BaseCloudRepository provideCloudRepository(NetworkModule networkModule, ApiService apiService) {
        return (BaseCloudRepository) Preconditions.checkNotNull(networkModule.provideCloudRepository(apiService), "Cannot return null from a non-@Nullable @Provides method");
    }
}
