package kz.sapasoft.emark.app.di.builder;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kz.sapasoft.emark.app.di.qualifier.ViewModelKey;
import kz.sapasoft.emark.app.ui.about.AboutViewModel;
import kz.sapasoft.emark.app.ui.map.MapViewModel;
import kz.sapasoft.emark.app.ui.marker.MarkerViewModel;
import kz.sapasoft.emark.app.ui.photo.PhotoViewModel;
import kz.sapasoft.emark.app.ui.projects.ProjectsViewModel;
import kz.sapasoft.emark.app.ui.settings.SettingsViewModel;
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H'J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H'¨\u0006\u0019"}, d2 = {"Lkz/sapasoft/emark/app/di/builder/AppViewModelBuilder;", "", "()V", "bindAboutViewModel", "Landroidx/lifecycle/ViewModel;", "aboutViewModel", "Lkz/sapasoft/emark/app/ui/about/AboutViewModel;", "bindHomeViewModel", "projectsViewModel", "Lkz/sapasoft/emark/app/ui/projects/ProjectsViewModel;", "bindMapViewModel", "mapViewModel", "Lkz/sapasoft/emark/app/ui/map/MapViewModel;", "bindMarkerViewModel", "markerViewModel", "Lkz/sapasoft/emark/app/ui/marker/MarkerViewModel;", "bindPhotoViewModel", "photoViewModel", "Lkz/sapasoft/emark/app/ui/photo/PhotoViewModel;", "bindSettingsViewModel", "settingsViewModel", "Lkz/sapasoft/emark/app/ui/settings/SettingsViewModel;", "bindWelcomeViewModel", "welcomeViewModel", "Lkz/sapasoft/emark/app/ui/welcome/WelcomeViewModel;", "app_release"}, k = 1, mv = {1, 1, 16})
@Module
/* compiled from: AppViewModelBuilder.kt */
public abstract class AppViewModelBuilder {
    @IntoMap
    @ViewModelKey(AboutViewModel.class)
    @Binds
    public abstract ViewModel bindAboutViewModel(AboutViewModel aboutViewModel);

    @IntoMap
    @ViewModelKey(ProjectsViewModel.class)
    @Binds
    public abstract ViewModel bindHomeViewModel(ProjectsViewModel projectsViewModel);

    @IntoMap
    @ViewModelKey(MapViewModel.class)
    @Binds
    public abstract ViewModel bindMapViewModel(MapViewModel mapViewModel);

    @IntoMap
    @ViewModelKey(MarkerViewModel.class)
    @Binds
    public abstract ViewModel bindMarkerViewModel(MarkerViewModel markerViewModel);

    @IntoMap
    @ViewModelKey(PhotoViewModel.class)
    @Binds
    public abstract ViewModel bindPhotoViewModel(PhotoViewModel photoViewModel);

    @IntoMap
    @ViewModelKey(SettingsViewModel.class)
    @Binds
    public abstract ViewModel bindSettingsViewModel(SettingsViewModel settingsViewModel);

    @IntoMap
    @ViewModelKey(WelcomeViewModel.class)
    @Binds
    public abstract ViewModel bindWelcomeViewModel(WelcomeViewModel welcomeViewModel);
}
