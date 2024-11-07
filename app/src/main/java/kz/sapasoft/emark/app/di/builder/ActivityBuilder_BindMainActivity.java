package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.MainActivity;

@Module(subcomponents = {ActivityBuilder_BindMainActivity.MainActivitySubcomponent.class})
public abstract class ActivityBuilder_BindMainActivity {

    @Subcomponent(modules = {MainActivityProviders.class})
    public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MainActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainActivitySubcomponent.Factory factory);

    private ActivityBuilder_BindMainActivity() {
    }
}
