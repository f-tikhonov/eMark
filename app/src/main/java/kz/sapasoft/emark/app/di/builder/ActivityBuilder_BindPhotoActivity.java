package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.photo.PhotoActivity;

@Module(subcomponents = {ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.class})
public abstract class ActivityBuilder_BindPhotoActivity {

    @Subcomponent
    public interface PhotoActivitySubcomponent extends AndroidInjector<PhotoActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<PhotoActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(PhotoActivity.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(PhotoActivitySubcomponent.Factory factory);

    private ActivityBuilder_BindPhotoActivity() {
    }
}
