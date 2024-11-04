package kz.sapasoft.emark.app.ui.main_fragments;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class MainFragment_MembersInjector implements MembersInjector<MainFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public MainFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<MainFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new MainFragment_MembersInjector(provider);
    }

    public void injectMembers(MainFragment mainFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(mainFragment, this.androidInjectorProvider.get());
    }
}
