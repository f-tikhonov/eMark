package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.main_fragments.MainFragment;

@Module(subcomponents = {MainFragmentSubcomponent.class})
public abstract class MainActivityProviders_ProvideMainFragment {

    @Subcomponent
    public interface MainFragmentSubcomponent extends AndroidInjector<MainFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MainFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(MainFragment.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainFragmentSubcomponent.Factory factory);

    private MainActivityProviders_ProvideMainFragment() {
    }
}
