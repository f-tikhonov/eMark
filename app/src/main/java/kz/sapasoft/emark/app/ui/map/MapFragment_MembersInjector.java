package kz.sapasoft.emark.app.ui.map;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideHomeDetailsFragment;

import javax.inject.Provider;

public final class MapFragment_MembersInjector implements MembersInjector<MapFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public MapFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<MapFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new MapFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(MapFragment mapFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(mapFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(mapFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(MapFragment mapFragment, ViewModelProvider.Factory factory) {
        mapFragment.viewModelFactory = (MainActivityProviders_ProvideHomeDetailsFragment.MapFragmentSubcomponent.Factory) factory;
    }
}
