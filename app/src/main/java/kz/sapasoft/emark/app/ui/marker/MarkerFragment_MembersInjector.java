package kz.sapasoft.emark.app.ui.marker;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class MarkerFragment_MembersInjector implements MembersInjector<MarkerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public MarkerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<MarkerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new MarkerFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(MarkerFragment markerFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(markerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(markerFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(MarkerFragment markerFragment, ViewModelProvider.Factory factory) {
        markerFragment.viewModelFactory = factory;
    }
}
