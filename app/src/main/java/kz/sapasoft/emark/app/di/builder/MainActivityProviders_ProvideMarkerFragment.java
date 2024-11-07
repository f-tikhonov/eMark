package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.marker.MarkerFragment;

@Module(subcomponents = {MainActivityProviders_ProvideMarkerFragment.MarkerFragmentSubcomponent.class})
public abstract class MainActivityProviders_ProvideMarkerFragment {

    @Subcomponent
    public interface MarkerFragmentSubcomponent extends AndroidInjector<MarkerFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MarkerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(MarkerFragment.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MarkerFragmentSubcomponent.Factory factory);

    private MainActivityProviders_ProvideMarkerFragment() {
    }
}
