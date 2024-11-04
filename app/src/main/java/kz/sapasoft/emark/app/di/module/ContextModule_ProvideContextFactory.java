package kz.sapasoft.emark.app.di.module;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ContextModule_ProvideContextFactory implements Factory<Context> {
    private final Provider<Application> applicationProvider;
    private final ContextModule module;

    public ContextModule_ProvideContextFactory(ContextModule contextModule, Provider<Application> provider) {
        this.module = contextModule;
        this.applicationProvider = provider;
    }

    public Context get() {
        return provideContext(this.module, this.applicationProvider.get());
    }

    public static ContextModule_ProvideContextFactory create(ContextModule contextModule, Provider<Application> provider) {
        return new ContextModule_ProvideContextFactory(contextModule, provider);
    }

    public static Context provideContext(ContextModule contextModule, Application application) {
        return (Context) Preconditions.checkNotNull(contextModule.provideContext(application), "Cannot return null from a non-@Nullable @Provides method");
    }
}
