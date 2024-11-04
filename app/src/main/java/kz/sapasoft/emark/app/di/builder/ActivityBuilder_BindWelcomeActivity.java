package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.welcome.WelcomeActivity;

@Module(subcomponents = {WelcomeActivitySubcomponent.class})
public abstract class ActivityBuilder_BindWelcomeActivity {

    @Subcomponent
    public interface WelcomeActivitySubcomponent extends AndroidInjector<WelcomeActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<WelcomeActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(WelcomeActivity.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(WelcomeActivitySubcomponent.Factory factory);

    private ActivityBuilder_BindWelcomeActivity() {
    }
}
