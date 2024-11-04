package kz.sapasoft.emark.app.di.component;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;
import kotlin.Metadata;
import kz.sapasoft.emark.app.core.App;
import kz.sapasoft.emark.app.di.builder.ActivityBuilder;
import kz.sapasoft.emark.app.di.module.ContextModule;
import kz.sapasoft.emark.app.di.module.DatabaseModule;
import kz.sapasoft.emark.app.di.module.NetworkModule;
import kz.sapasoft.emark.app.di.module.PrefsModule;

@Component(modules = {AndroidSupportInjectionModule.class, NetworkModule.class, ActivityBuilder.class, ContextModule.class, DatabaseModule.class, PrefsModule.class})
@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lkz/sapasoft/emark/app/di/component/CoreComponent;", "Ldagger/android/AndroidInjector;", "Lkz/sapasoft/emark/app/core/App;", "Builder", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CoreComponent.kt */
public interface CoreComponent extends AndroidInjector<App> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lkz/sapasoft/emark/app/di/component/CoreComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lkz/sapasoft/emark/app/di/component/CoreComponent;", "app_release"}, k = 1, mv = {1, 1, 16})
    @Component.Builder
    /* compiled from: CoreComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder application(Application application);

        CoreComponent build();
    }
}
