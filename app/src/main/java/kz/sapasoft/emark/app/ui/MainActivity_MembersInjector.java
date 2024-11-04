package kz.sapasoft.emark.app.ui;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public MainActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<MainActivity> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new MainActivity_MembersInjector(provider);
    }

    public void injectMembers(MainActivity mainActivity) {
        DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(mainActivity, this.androidInjectorProvider.get());
    }
}
