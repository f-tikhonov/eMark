package kz.sapasoft.emark.app.ui.about;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class AboutFragment_MembersInjector implements MembersInjector<AboutFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AboutFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<AboutFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new AboutFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(AboutFragment aboutFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(aboutFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(aboutFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(AboutFragment aboutFragment, ViewModelProvider.Factory factory) {
        aboutFragment.viewModelFactory = factory;
    }
}
