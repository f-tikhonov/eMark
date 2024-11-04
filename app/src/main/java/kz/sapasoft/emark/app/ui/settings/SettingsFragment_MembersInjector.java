package kz.sapasoft.emark.app.ui.settings;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class SettingsFragment_MembersInjector implements MembersInjector<SettingsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SettingsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<SettingsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new SettingsFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(SettingsFragment settingsFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(settingsFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(settingsFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(SettingsFragment settingsFragment, ViewModelProvider.Factory factory) {
        settingsFragment.viewModelFactory = factory;
    }
}
