package kz.sapasoft.emark.app.core;

import dagger.MembersInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class App_MembersInjector implements MembersInjector<App> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public App_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<App> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new App_MembersInjector(provider);
    }

    public void injectMembers(App app) {
        DaggerApplication_MembersInjector.injectAndroidInjector(app, this.androidInjectorProvider.get());
    }
}
