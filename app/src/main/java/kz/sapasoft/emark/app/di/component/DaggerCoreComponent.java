package kz.sapasoft.emark.app.di.component;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import kz.sapasoft.emark.app.core.App;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.cloud.rest.ApiService;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl_Factory;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;
import kz.sapasoft.emark.app.data.local.room.image.ImageDao;
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerDao;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncDao;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository;
import kz.sapasoft.emark.app.data.local.room.project.ProjectDao;
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository;
import kz.sapasoft.emark.app.data.local.room.tag.TagDao;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;
import kz.sapasoft.emark.app.data.local.room.template.TemplateDao;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;
import kz.sapasoft.emark.app.di.builder.ActivityBuilder_BindMainActivity;
import kz.sapasoft.emark.app.di.builder.ActivityBuilder_BindPhotoActivity;
import kz.sapasoft.emark.app.di.builder.ActivityBuilder_BindWelcomeActivity;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideAboutFragment;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideHomeDetailsFragment;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideHomeFragment;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideMainFragment;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideMarkerFragment;
import kz.sapasoft.emark.app.di.builder.MainActivityProviders_ProvideSettingsFragment;
import kz.sapasoft.emark.app.di.module.ContextModule;
import kz.sapasoft.emark.app.di.module.ContextModule_ProvideContextFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ImageRepositoryFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_MarkerRepositoryFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_MarkerSyncRepositoryFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProjectRepositoryFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProvidesImageDaoFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProvidesMarkerDaoFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProvidesMarkerSyncDaoFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProvidesProjectDaoFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProvidesRoomDatabaseFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProvidesTagDaoFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_ProvidesTemplateDaoFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_TagRepositoryFactory;
import kz.sapasoft.emark.app.di.module.DatabaseModule_TemplateRepositoryFactory;
import kz.sapasoft.emark.app.di.module.NetworkModule;
import kz.sapasoft.emark.app.di.module.NetworkModule_ProvideCloudRepositoryFactory;
import kz.sapasoft.emark.app.di.module.NetworkModule_ProvideServiceFactory;
import kz.sapasoft.emark.app.di.module.NetworkModule_ProvidesGsonConverterFactoryFactory;
import kz.sapasoft.emark.app.di.module.NetworkModule_ProvidesOkHttpClientFactory;
import kz.sapasoft.emark.app.di.module.NetworkModule_ProvidesRetrofitFactory;
import kz.sapasoft.emark.app.ui.MainActivity;
import kz.sapasoft.emark.app.ui.ViewModelFactory;
import kz.sapasoft.emark.app.ui.ViewModelFactory_Factory;
import kz.sapasoft.emark.app.ui.about.AboutFragment;
import kz.sapasoft.emark.app.ui.about.AboutFragment_MembersInjector;
import kz.sapasoft.emark.app.ui.about.AboutViewModel;
import kz.sapasoft.emark.app.ui.about.AboutViewModel_Factory;
import kz.sapasoft.emark.app.ui.main_fragments.MainFragment;
import kz.sapasoft.emark.app.ui.map.MapFragment;
import kz.sapasoft.emark.app.ui.map.MapFragment_MembersInjector;
import kz.sapasoft.emark.app.ui.map.MapViewModel;
import kz.sapasoft.emark.app.ui.map.MapViewModel_Factory;
import kz.sapasoft.emark.app.ui.marker.MarkerFragment;
import kz.sapasoft.emark.app.ui.marker.MarkerFragment_MembersInjector;
import kz.sapasoft.emark.app.ui.marker.MarkerViewModel;
import kz.sapasoft.emark.app.ui.marker.MarkerViewModel_Factory;
import kz.sapasoft.emark.app.ui.photo.PhotoActivity;
import kz.sapasoft.emark.app.ui.photo.PhotoActivity_MembersInjector;
import kz.sapasoft.emark.app.ui.photo.PhotoViewModel;
import kz.sapasoft.emark.app.ui.photo.PhotoViewModel_Factory;
import kz.sapasoft.emark.app.ui.projects.ProjectsFragment;
import kz.sapasoft.emark.app.ui.projects.ProjectsFragment_MembersInjector;
import kz.sapasoft.emark.app.ui.projects.ProjectsViewModel;
import kz.sapasoft.emark.app.ui.projects.ProjectsViewModel_Factory;
import kz.sapasoft.emark.app.ui.settings.SettingsFragment;
import kz.sapasoft.emark.app.ui.settings.SettingsFragment_MembersInjector;
import kz.sapasoft.emark.app.ui.settings.SettingsViewModel;
import kz.sapasoft.emark.app.ui.settings.SettingsViewModel_Factory;
import kz.sapasoft.emark.app.ui.welcome.WelcomeActivity;
import kz.sapasoft.emark.app.ui.welcome.WelcomeActivity_MembersInjector;
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel;
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel_Factory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class DaggerCoreComponent implements CoreComponent {
    private Provider<AboutViewModel> aboutViewModelProvider;
    private Provider<Application> applicationProvider;
    private Provider<ImageRepository> imageRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory> mainActivitySubcomponentFactoryProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private Provider<MapViewModel> mapViewModelProvider;
    private Provider<MarkerRepository> markerRepositoryProvider;
    private Provider<MarkerSyncRepository> markerSyncRepositoryProvider;
    private Provider<MarkerViewModel> markerViewModelProvider;
    /* access modifiers changed from: private */
    public Provider<ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory> photoActivitySubcomponentFactoryProvider;
    private Provider<PhotoViewModel> photoViewModelProvider;
    private Provider<PrefsImpl> prefsImplProvider;
    private Provider<ProjectRepository> projectRepositoryProvider;
    private Provider<ProjectsViewModel> projectsViewModelProvider;
    private Provider<BaseCloudRepository> provideCloudRepositoryProvider;
    private Provider<Context> provideContextProvider;
    private Provider<ApiService> provideServiceProvider;
    private Provider<GsonConverterFactory> providesGsonConverterFactoryProvider;
    private Provider<ImageDao> providesImageDaoProvider;
    private Provider<MarkerDao> providesMarkerDaoProvider;
    private Provider<MarkerSyncDao> providesMarkerSyncDaoProvider;
    private Provider<OkHttpClient> providesOkHttpClientProvider;
    private Provider<ProjectDao> providesProjectDaoProvider;
    private Provider<Retrofit> providesRetrofitProvider;
    private Provider<LocalDatabase> providesRoomDatabaseProvider;
    private Provider<TagDao> providesTagDaoProvider;
    private Provider<TemplateDao> providesTemplateDaoProvider;
    private Provider<SettingsViewModel> settingsViewModelProvider;
    private Provider<TagRepository> tagRepositoryProvider;
    private Provider<TemplateRepository> templateRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<ViewModelFactory> viewModelFactoryProvider;
    /* access modifiers changed from: private */
    public Provider<ActivityBuilder_BindWelcomeActivity.WelcomeActivitySubcomponent.Factory> welcomeActivitySubcomponentFactoryProvider;
    private Provider<WelcomeViewModel> welcomeViewModelProvider;

    private DaggerCoreComponent(NetworkModule networkModule, ContextModule contextModule, DatabaseModule databaseModule, Application application) {
        initialize(networkModule, contextModule, databaseModule, application);
    }

    public static CoreComponent.Builder builder() {
        return new Builder();
    }

    private Map<Object, Object> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
        return MapBuilder.newMapBuilder(3).put(WelcomeActivity.class, this.welcomeActivitySubcomponentFactoryProvider).put(MainActivity.class, this.mainActivitySubcomponentFactoryProvider).put(PhotoActivity.class, this.photoActivitySubcomponentFactoryProvider).build();
    }

    /* access modifiers changed from: private */
    public DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
        return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.emptyMap());
    }

    private void initialize(NetworkModule networkModule, ContextModule contextModule, DatabaseModule databaseModule, Application application) {
        this.welcomeActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindWelcomeActivity.WelcomeActivitySubcomponent.Factory>() {
            public ActivityBuilder_BindWelcomeActivity.WelcomeActivitySubcomponent.Factory get() {
                return new WelcomeActivitySubcomponentFactory();
            }
        };
        this.mainActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory>() {
            public ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory get() {
                return new MainActivitySubcomponentFactory();
            }
        };
        this.photoActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory>() {
            public ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory get() {
                return new PhotoActivitySubcomponentFactory();
            }
        };
        Factory create = (Factory) InstanceFactory.create(application);
        this.applicationProvider = (Provider<Application>) create;
        Provider<Context> provider = DoubleCheck.provider(ContextModule_ProvideContextFactory.create(contextModule, (Provider<Application>) create));
        this.provideContextProvider = provider;
        this.prefsImplProvider = PrefsImpl_Factory.create(provider);
        this.providesGsonConverterFactoryProvider = DoubleCheck.provider(NetworkModule_ProvidesGsonConverterFactoryFactory.create(networkModule));
        Provider<OkHttpClient> provider2 = DoubleCheck.provider(NetworkModule_ProvidesOkHttpClientFactory.create(networkModule, this.provideContextProvider));
        this.providesOkHttpClientProvider = provider2;
        Provider<Retrofit> provider3 = DoubleCheck.provider(NetworkModule_ProvidesRetrofitFactory.create(networkModule, this.providesGsonConverterFactoryProvider, provider2));
        this.providesRetrofitProvider = provider3;
        Provider<ApiService> provider4 = DoubleCheck.provider(NetworkModule_ProvideServiceFactory.create(networkModule, provider3));
        this.provideServiceProvider = provider4;
        this.provideCloudRepositoryProvider = DoubleCheck.provider(NetworkModule_ProvideCloudRepositoryFactory.create(networkModule, provider4));
        Provider<LocalDatabase> provider5 = DoubleCheck.provider(DatabaseModule_ProvidesRoomDatabaseFactory.create(databaseModule));
        this.providesRoomDatabaseProvider = provider5;
        Provider<ProjectDao> provider6 = DoubleCheck.provider(DatabaseModule_ProvidesProjectDaoFactory.create(databaseModule, provider5));
        this.providesProjectDaoProvider = provider6;
        this.projectRepositoryProvider = DoubleCheck.provider(DatabaseModule_ProjectRepositoryFactory.create(databaseModule, provider6));
        Provider<TagDao> provider7 = DoubleCheck.provider(DatabaseModule_ProvidesTagDaoFactory.create(databaseModule, this.providesRoomDatabaseProvider));
        this.providesTagDaoProvider = provider7;
        Provider<TagRepository> provider8 = DoubleCheck.provider(DatabaseModule_TagRepositoryFactory.create(databaseModule, provider7));
        this.tagRepositoryProvider = provider8;
        this.projectsViewModelProvider = ProjectsViewModel_Factory.create(this.prefsImplProvider, this.provideCloudRepositoryProvider, this.projectRepositoryProvider, provider8);
        Provider<TemplateDao> provider9 = DoubleCheck.provider(DatabaseModule_ProvidesTemplateDaoFactory.create(databaseModule, this.providesRoomDatabaseProvider));
        this.providesTemplateDaoProvider = provider9;
        this.templateRepositoryProvider = DoubleCheck.provider(DatabaseModule_TemplateRepositoryFactory.create(databaseModule, provider9));
        Provider<ImageDao> provider10 = DoubleCheck.provider(DatabaseModule_ProvidesImageDaoFactory.create(databaseModule, this.providesRoomDatabaseProvider));
        this.providesImageDaoProvider = provider10;
        this.imageRepositoryProvider = DoubleCheck.provider(DatabaseModule_ImageRepositoryFactory.create(databaseModule, provider10));
        Provider<MarkerDao> provider11 = DoubleCheck.provider(DatabaseModule_ProvidesMarkerDaoFactory.create(databaseModule, this.providesRoomDatabaseProvider));
        this.providesMarkerDaoProvider = provider11;
        this.markerRepositoryProvider = DoubleCheck.provider(DatabaseModule_MarkerRepositoryFactory.create(databaseModule, provider11));
        Provider<MarkerSyncDao> provider12 = DoubleCheck.provider(DatabaseModule_ProvidesMarkerSyncDaoFactory.create(databaseModule, this.providesRoomDatabaseProvider));
        this.providesMarkerSyncDaoProvider = provider12;
        Provider<MarkerSyncRepository> provider13 = DoubleCheck.provider(DatabaseModule_MarkerSyncRepositoryFactory.create(databaseModule, provider12));
        this.markerSyncRepositoryProvider = provider13;
        this.mapViewModelProvider = MapViewModel_Factory.create(this.provideCloudRepositoryProvider, this.templateRepositoryProvider, this.imageRepositoryProvider, this.markerRepositoryProvider, provider13, this.prefsImplProvider);
        this.markerViewModelProvider = MarkerViewModel_Factory.create(this.provideCloudRepositoryProvider, this.prefsImplProvider, this.templateRepositoryProvider, this.imageRepositoryProvider, this.markerSyncRepositoryProvider, this.tagRepositoryProvider);
        this.settingsViewModelProvider = SettingsViewModel_Factory.create(this.prefsImplProvider, this.provideContextProvider, this.provideCloudRepositoryProvider, this.projectRepositoryProvider, this.tagRepositoryProvider, this.templateRepositoryProvider, this.markerRepositoryProvider);
        this.aboutViewModelProvider = AboutViewModel_Factory.create(this.prefsImplProvider, this.provideCloudRepositoryProvider);
        this.welcomeViewModelProvider = WelcomeViewModel_Factory.create(this.prefsImplProvider, this.provideContextProvider, this.provideCloudRepositoryProvider);
        this.photoViewModelProvider = PhotoViewModel_Factory.create(this.prefsImplProvider, this.provideContextProvider, this.provideCloudRepositoryProvider);
        MapProviderFactory build = MapProviderFactory.builder(7).put((Object) ProjectsViewModel.class, (Provider) this.projectsViewModelProvider).put((Object) MapViewModel.class, (Provider) this.mapViewModelProvider).put((Object) MarkerViewModel.class, (Provider) this.markerViewModelProvider).put((Object) SettingsViewModel.class, (Provider) this.settingsViewModelProvider).put((Object) AboutViewModel.class, (Provider) this.aboutViewModelProvider).put((Object) WelcomeViewModel.class, (Provider) this.welcomeViewModelProvider).put((Object) PhotoViewModel.class, (Provider) this.photoViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = build;
        this.viewModelFactoryProvider = DoubleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public void inject(App app) {
        injectApp(app);
    }

    private App injectApp(App app) {
        DaggerApplication_MembersInjector.injectAndroidInjector(app, getDispatchingAndroidInjectorOfObject());
        return app;
    }

    private static final class Builder implements CoreComponent.Builder {
        private Application application;

        private Builder() {
        }

        public Builder application(Application application2) {
            this.application = (Application) Preconditions.checkNotNull(application2);
            return this;
        }

        public CoreComponent build() {
            Preconditions.checkBuilderRequirement(this.application, Application.class);
            return new DaggerCoreComponent(new NetworkModule(), new ContextModule(), new DatabaseModule(), this.application);
        }
    }

    private final class WelcomeActivitySubcomponentFactory implements ActivityBuilder_BindWelcomeActivity.WelcomeActivitySubcomponent.Factory {
        private WelcomeActivitySubcomponentFactory() {
        }

        public ActivityBuilder_BindWelcomeActivity.WelcomeActivitySubcomponent create(WelcomeActivity welcomeActivity) {
            Preconditions.checkNotNull(welcomeActivity);
            return new WelcomeActivitySubcomponentImpl(welcomeActivity);
        }
    }

    private final class WelcomeActivitySubcomponentImpl implements ActivityBuilder_BindWelcomeActivity.WelcomeActivitySubcomponent {
        private WelcomeActivitySubcomponentImpl(WelcomeActivity welcomeActivity) {
        }

        public void inject(WelcomeActivity welcomeActivity) {
            injectWelcomeActivity(welcomeActivity);
        }

        private WelcomeActivity injectWelcomeActivity(WelcomeActivity welcomeActivity) {
            DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(welcomeActivity, DaggerCoreComponent.this.getDispatchingAndroidInjectorOfObject());
            WelcomeActivity_MembersInjector.injectViewModelFactory(welcomeActivity, (ViewModelProvider.Factory) DaggerCoreComponent.this.viewModelFactoryProvider.get());
            return welcomeActivity;
        }
    }

    private final class MainActivitySubcomponentFactory implements ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory {
        private MainActivitySubcomponentFactory() {
        }

        public ActivityBuilder_BindMainActivity.MainActivitySubcomponent create(MainActivity mainActivity) {
            Preconditions.checkNotNull(mainActivity);
            return new MainActivitySubcomponentImpl(mainActivity);
        }
    }

    private final class MainActivitySubcomponentImpl implements ActivityBuilder_BindMainActivity.MainActivitySubcomponent {
        private Provider<MainActivityProviders_ProvideAboutFragment.AboutFragmentSubcomponent.Factory> aboutFragmentSubcomponentFactoryProvider;
        private Provider<MainActivityProviders_ProvideMainFragment.MainFragmentSubcomponent.Factory> mainFragmentSubcomponentFactoryProvider;
        private Provider<MainActivityProviders_ProvideHomeDetailsFragment.MapFragmentSubcomponent.Factory> mapFragmentSubcomponentFactoryProvider;
        private Provider<MainActivityProviders_ProvideMarkerFragment.MarkerFragmentSubcomponent.Factory> markerFragmentSubcomponentFactoryProvider;
        private Provider<MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent.Factory> projectsFragmentSubcomponentFactoryProvider;
        private Provider<MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory> settingsFragmentSubcomponentFactoryProvider;

        private MainActivitySubcomponentImpl(MainActivity mainActivity) {
            initialize(mainActivity);
        }

        private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
            return MapBuilder.newMapBuilder(9).put(WelcomeActivity.class, DaggerCoreComponent.this.welcomeActivitySubcomponentFactoryProvider).put(MainActivity.class, DaggerCoreComponent.this.mainActivitySubcomponentFactoryProvider).put(PhotoActivity.class, DaggerCoreComponent.this.photoActivitySubcomponentFactoryProvider).put(MainFragment.class, this.mainFragmentSubcomponentFactoryProvider).put(ProjectsFragment.class, this.projectsFragmentSubcomponentFactoryProvider).put(MapFragment.class, this.mapFragmentSubcomponentFactoryProvider).put(MarkerFragment.class, this.markerFragmentSubcomponentFactoryProvider).put(SettingsFragment.class, this.settingsFragmentSubcomponentFactoryProvider).put(AboutFragment.class, this.aboutFragmentSubcomponentFactoryProvider).build();
        }

        /* access modifiers changed from: private */
        public DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
            return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.emptyMap());
        }

        private void initialize(MainActivity mainActivity) {
            this.mainFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideMainFragment.MainFragmentSubcomponent.Factory>() {
                public MainActivityProviders_ProvideMainFragment.MainFragmentSubcomponent.Factory get() {
                    return new MainFragmentSubcomponentFactory();
                }
            };
            this.projectsFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent.Factory>() {
                public MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent.Factory get() {
                    return new ProjectsFragmentSubcomponentFactory();
                }
            };
            this.mapFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideHomeDetailsFragment.MapFragmentSubcomponent.Factory>() {
                public MainActivityProviders_ProvideHomeDetailsFragment.MapFragmentSubcomponent.Factory get() {
                    return new MapFragmentSubcomponentFactory();
                }
            };
            this.markerFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideMarkerFragment.MarkerFragmentSubcomponent.Factory>() {
                public MainActivityProviders_ProvideMarkerFragment.MarkerFragmentSubcomponent.Factory get() {
                    return new MarkerFragmentSubcomponentFactory();
                }
            };
            this.settingsFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory>() {
                public MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory get() {
                    return new SettingsFragmentSubcomponentFactory();
                }
            };
            this.aboutFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideAboutFragment.AboutFragmentSubcomponent.Factory>() {
                public MainActivityProviders_ProvideAboutFragment.AboutFragmentSubcomponent.Factory get() {
                    return new AboutFragmentSubcomponentFactory();
                }
            };
        }

        public void inject(MainActivity mainActivity) {
            injectMainActivity(mainActivity);
        }

        private MainActivity injectMainActivity(MainActivity mainActivity) {
            DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(mainActivity, getDispatchingAndroidInjectorOfObject());
            return mainActivity;
        }

        private final class MainFragmentSubcomponentFactory implements MainActivityProviders_ProvideMainFragment.MainFragmentSubcomponent.Factory {
            private MainFragmentSubcomponentFactory() {
            }

            public MainActivityProviders_ProvideMainFragment.MainFragmentSubcomponent create(MainFragment mainFragment) {
                Preconditions.checkNotNull(mainFragment);
                return new MainFragmentSubcomponentImpl(mainFragment);
            }
        }

        private final class MainFragmentSubcomponentImpl implements MainActivityProviders_ProvideMainFragment.MainFragmentSubcomponent {
            private MainFragmentSubcomponentImpl(MainFragment mainFragment) {
            }

            public void inject(MainFragment mainFragment) {
                injectMainFragment(mainFragment);
            }

            private MainFragment injectMainFragment(MainFragment mainFragment) {
                DaggerFragment_MembersInjector.injectAndroidInjector(mainFragment, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
                return mainFragment;
            }
        }

        private final class ProjectsFragmentSubcomponentFactory implements MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent.Factory {
            private ProjectsFragmentSubcomponentFactory() {
            }

            public MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent create(ProjectsFragment projectsFragment) {
                Preconditions.checkNotNull(projectsFragment);
                return new ProjectsFragmentSubcomponentImpl(projectsFragment);
            }
        }

        private final class ProjectsFragmentSubcomponentImpl implements MainActivityProviders_ProvideHomeFragment.ProjectsFragmentSubcomponent {
            private ProjectsFragmentSubcomponentImpl(ProjectsFragment projectsFragment) {
            }

            public void inject(ProjectsFragment projectsFragment) {
                injectProjectsFragment(projectsFragment);
            }

            private ProjectsFragment injectProjectsFragment(ProjectsFragment projectsFragment) {
                DaggerFragment_MembersInjector.injectAndroidInjector(projectsFragment, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
                ProjectsFragment_MembersInjector.injectViewModelFactory(projectsFragment, (ViewModelProvider.Factory) DaggerCoreComponent.this.viewModelFactoryProvider.get());
                return projectsFragment;
            }
        }

        private final class MapFragmentSubcomponentFactory implements MainActivityProviders_ProvideHomeDetailsFragment.MapFragmentSubcomponent.Factory {
            private MapFragmentSubcomponentFactory() {
            }

            public MainActivityProviders_ProvideHomeDetailsFragment.MapFragmentSubcomponent create(MapFragment mapFragment) {
                Preconditions.checkNotNull(mapFragment);
                return new MapFragmentSubcomponentImpl(mapFragment);
            }
        }

        private final class MapFragmentSubcomponentImpl implements MainActivityProviders_ProvideHomeDetailsFragment.MapFragmentSubcomponent {
            private MapFragmentSubcomponentImpl(MapFragment mapFragment) {
            }

            public void inject(MapFragment mapFragment) {
                injectMapFragment(mapFragment);
            }

            private MapFragment injectMapFragment(MapFragment mapFragment) {
                DaggerFragment_MembersInjector.injectAndroidInjector(mapFragment, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
                MapFragment_MembersInjector.injectViewModelFactory(mapFragment, (ViewModelProvider.Factory) DaggerCoreComponent.this.viewModelFactoryProvider.get());
                return mapFragment;
            }
        }

        private final class MarkerFragmentSubcomponentFactory implements MainActivityProviders_ProvideMarkerFragment.MarkerFragmentSubcomponent.Factory {
            private MarkerFragmentSubcomponentFactory() {
            }

            public MainActivityProviders_ProvideMarkerFragment.MarkerFragmentSubcomponent create(MarkerFragment markerFragment) {
                Preconditions.checkNotNull(markerFragment);
                return new MarkerFragmentSubcomponentImpl(markerFragment);
            }
        }

        private final class MarkerFragmentSubcomponentImpl implements MainActivityProviders_ProvideMarkerFragment.MarkerFragmentSubcomponent {
            private MarkerFragmentSubcomponentImpl(MarkerFragment markerFragment) {
            }

            public void inject(MarkerFragment markerFragment) {
                injectMarkerFragment(markerFragment);
            }

            private MarkerFragment injectMarkerFragment(MarkerFragment markerFragment) {
                DaggerFragment_MembersInjector.injectAndroidInjector(markerFragment, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
                MarkerFragment_MembersInjector.injectViewModelFactory(markerFragment, (ViewModelProvider.Factory) DaggerCoreComponent.this.viewModelFactoryProvider.get());
                return markerFragment;
            }
        }

        private final class SettingsFragmentSubcomponentFactory implements MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory {
            private SettingsFragmentSubcomponentFactory() {
            }

            public MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent create(SettingsFragment settingsFragment) {
                Preconditions.checkNotNull(settingsFragment);
                return new SettingsFragmentSubcomponentImpl(settingsFragment);
            }
        }

        private final class SettingsFragmentSubcomponentImpl implements MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent {
            private SettingsFragmentSubcomponentImpl(SettingsFragment settingsFragment) {
            }

            public void inject(SettingsFragment settingsFragment) {
                injectSettingsFragment(settingsFragment);
            }

            private SettingsFragment injectSettingsFragment(SettingsFragment settingsFragment) {
                DaggerFragment_MembersInjector.injectAndroidInjector(settingsFragment, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
                SettingsFragment_MembersInjector.injectViewModelFactory(settingsFragment, (ViewModelProvider.Factory) DaggerCoreComponent.this.viewModelFactoryProvider.get());
                return settingsFragment;
            }
        }

        private final class AboutFragmentSubcomponentFactory implements MainActivityProviders_ProvideAboutFragment.AboutFragmentSubcomponent.Factory {
            private AboutFragmentSubcomponentFactory() {
            }

            public MainActivityProviders_ProvideAboutFragment.AboutFragmentSubcomponent create(AboutFragment aboutFragment) {
                Preconditions.checkNotNull(aboutFragment);
                return new AboutFragmentSubcomponentImpl(aboutFragment);
            }
        }

        private final class AboutFragmentSubcomponentImpl implements MainActivityProviders_ProvideAboutFragment.AboutFragmentSubcomponent {
            private AboutFragmentSubcomponentImpl(AboutFragment aboutFragment) {
            }

            public void inject(AboutFragment aboutFragment) {
                injectAboutFragment(aboutFragment);
            }

            private AboutFragment injectAboutFragment(AboutFragment aboutFragment) {
                DaggerFragment_MembersInjector.injectAndroidInjector(aboutFragment, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
                AboutFragment_MembersInjector.injectViewModelFactory(aboutFragment, (ViewModelProvider.Factory) DaggerCoreComponent.this.viewModelFactoryProvider.get());
                return aboutFragment;
            }
        }
    }

    private final class PhotoActivitySubcomponentFactory implements ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory {
        private PhotoActivitySubcomponentFactory() {
        }

        public ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent create(PhotoActivity photoActivity) {
            Preconditions.checkNotNull(photoActivity);
            return new PhotoActivitySubcomponentImpl(photoActivity);
        }
    }

    private final class PhotoActivitySubcomponentImpl implements ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent {
        private PhotoActivitySubcomponentImpl(PhotoActivity photoActivity) {
        }

        public void inject(PhotoActivity photoActivity) {
            injectPhotoActivity(photoActivity);
        }

        private PhotoActivity injectPhotoActivity(PhotoActivity photoActivity) {
            DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(photoActivity, DaggerCoreComponent.this.getDispatchingAndroidInjectorOfObject());
            PhotoActivity_MembersInjector.injectViewModelFactory(photoActivity, (ViewModelProvider.Factory) DaggerCoreComponent.this.viewModelFactoryProvider.get());
            return photoActivity;
        }
    }
}
