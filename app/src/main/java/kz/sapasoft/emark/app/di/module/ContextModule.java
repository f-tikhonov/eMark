package kz.sapasoft.emark.app.di.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.di.builder.ViewModelBuilder;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lkz/sapasoft/emark/app/di/module/ContextModule;", "", "()V", "provideContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "app_release"}, k = 1, mv = {1, 1, 16})
@Module(includes = {ViewModelBuilder.class})
/* compiled from: ContextModule.kt */
public final class ContextModule {
    @Singleton
    @Provides
    public final Context provideContext(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        return application;
    }
}
