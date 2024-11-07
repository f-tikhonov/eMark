package kz.sapasoft.emark.app.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kz.sapasoft.emark.app.ui.projects.ProjectsFragment;

@Module(subcomponents = {MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent.class})
public abstract class MainActivityProviders_ProvideHomeFragment {

    @Subcomponent
    public interface ProjectsFragmentSubcomponent extends AndroidInjector<ProjectsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ProjectsFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ClassKey(ProjectsFragment.class)
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ProjectsFragmentSubcomponent.Factory factory);

    private MainActivityProviders_ProvideHomeFragment() {
    }
}
