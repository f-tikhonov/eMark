package kz.sapasoft.emark.app.ui.base;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class DaggerFragmentExtended_MembersInjector implements MembersInjector<DaggerFragmentExtended> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerFragmentExtended_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerFragmentExtended> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerFragmentExtended_MembersInjector(provider);
    }

    public void injectMembers(DaggerFragmentExtended daggerFragmentExtended) {
        DaggerFragment_MembersInjector.injectAndroidInjector(daggerFragmentExtended, this.androidInjectorProvider.get());
    }
}
