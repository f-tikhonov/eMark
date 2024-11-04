package kz.sapasoft.emark.app.data.local.prefs;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PrefsImpl_Factory implements Factory<PrefsImpl> {
    private final Provider<Context> appContextProvider;

    public PrefsImpl_Factory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    public PrefsImpl get() {
        return newInstance(this.appContextProvider.get());
    }

    public static PrefsImpl_Factory create(Provider<Context> provider) {
        return new PrefsImpl_Factory(provider);
    }

    public static PrefsImpl newInstance(Context context) {
        return new PrefsImpl(context);
    }
}
