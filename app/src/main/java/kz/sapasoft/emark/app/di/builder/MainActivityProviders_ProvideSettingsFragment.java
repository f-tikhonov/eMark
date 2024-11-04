package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.settings.SettingsFragment;

@Module(subcomponents = {SettingsFragmentSubcomponent.class})
public abstract class MainActivityProviders_ProvideSettingsFragment {

    @Subcomponent
    public interface SettingsFragmentSubcomponent extends AndroidInjector<SettingsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SettingsFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(SettingsFragment.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SettingsFragmentSubcomponent.Factory factory);

    private MainActivityProviders_ProvideSettingsFragment() {
    }
}
