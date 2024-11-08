package kz.sapasoft.emark.app.ui.projects;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideHomeFragment;

import javax.inject.Provider;

public final class ProjectsFragment_MembersInjector implements MembersInjector<ProjectsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ProjectsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<ProjectsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ProjectsFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(ProjectsFragment projectsFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(projectsFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(projectsFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(ProjectsFragment projectsFragment, ViewModelProvider.Factory factory) {
        projectsFragment.viewModelFactory = (MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent.Factory) factory;
    }
}
