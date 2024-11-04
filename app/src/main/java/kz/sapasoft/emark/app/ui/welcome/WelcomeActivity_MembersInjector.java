package kz.sapasoft.emark.app.ui.welcome;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import javax.inject.Provider;

public final class WelcomeActivity_MembersInjector implements MembersInjector<WelcomeActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public WelcomeActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<WelcomeActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new WelcomeActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(WelcomeActivity welcomeActivity) {
        DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(welcomeActivity, this.androidInjectorProvider.get());
        injectViewModelFactory(welcomeActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(WelcomeActivity welcomeActivity, ViewModelProvider.Factory factory) {
        welcomeActivity.viewModelFactory = factory;
    }
}
