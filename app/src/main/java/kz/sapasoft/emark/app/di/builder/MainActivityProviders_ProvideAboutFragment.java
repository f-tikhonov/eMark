package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.about.AboutFragment;

@Module(subcomponents = {AboutFragmentSubcomponent.class})
public abstract class MainActivityProviders_ProvideAboutFragment {

    @Subcomponent
    public interface AboutFragmentSubcomponent extends AndroidInjector<AboutFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AboutFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(AboutFragment.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AboutFragmentSubcomponent.Factory factory);

    private MainActivityProviders_ProvideAboutFragment() {
    }
}
