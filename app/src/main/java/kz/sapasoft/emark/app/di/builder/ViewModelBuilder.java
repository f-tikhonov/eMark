package kz.sapasoft.emark.app.di.builder;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import kz.sapasoft.emark.app.di.module.PrefsModule;
import kz.sapasoft.emark.app.ui.ViewModelFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lkz/sapasoft/emark/app/di/builder/ViewModelBuilder;", "", "()V", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lkz/sapasoft/emark/app/ui/ViewModelFactory;", "app_release"}, k = 1, mv = {1, 1, 16})
@Module(includes = {PrefsModule.class, AppViewModelBuilder.class})
/* compiled from: ViewModelBuilder.kt */
public abstract class ViewModelBuilder {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
