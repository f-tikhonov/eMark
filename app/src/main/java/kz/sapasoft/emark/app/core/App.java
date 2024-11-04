package kz.sapasoft.emark.app.core;

import android.content.Context;
import androidx.multidex.MultiDex;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.di.component.DaggerCoreComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004H\u0014J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/core/App;", "Ldagger/android/DaggerApplication;", "()V", "applicationInjector", "Ldagger/android/AndroidInjector;", "attachBaseContext", "", "base", "Landroid/content/Context;", "onCreate", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: App.kt */
public final class App extends DaggerApplication {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static App instance;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkz/sapasoft/emark/app/core/App$Companion;", "", "()V", "<set-?>", "Lkz/sapasoft/emark/app/core/App;", "instance", "getInstance", "()Lkz/sapasoft/emark/app/core/App;", "setInstance", "(Lkz/sapasoft/emark/app/core/App;)V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: App.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void setInstance(App app) {
            App.instance = app;
        }

        public final App getInstance() {
            App access$getInstance$cp = App.instance;
            if (access$getInstance$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("instance");
            }
            return access$getInstance$cp;
        }
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /* access modifiers changed from: protected */
    public AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerCoreComponent.builder().application(this).build();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "base");
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
