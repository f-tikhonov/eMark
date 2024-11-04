package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.map.MapFragment;

@Module(subcomponents = {MapFragmentSubcomponent.class})
public abstract class MainActivityProviders_ProvideHomeDetailsFragment {

    @Subcomponent
    public interface MapFragmentSubcomponent extends AndroidInjector<MapFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MapFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(MapFragment.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MapFragmentSubcomponent.Factory factory);

    private MainActivityProviders_ProvideHomeDetailsFragment() {
    }
}
