package kz.sapasoft.emark.app.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kotlin.Metadata;
import kz.sapasoft.emark.app.ui.MainActivity;
import kz.sapasoft.emark.app.ui.photo.PhotoActivity;
import kz.sapasoft.emark.app.ui.welcome.WelcomeActivity;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0005\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lkz/sapasoft/emark/app/di/builder/ActivityBuilder;", "", "()V", "bindMainActivity", "Lkz/sapasoft/emark/app/ui/MainActivity;", "bindPhotoActivity", "Lkz/sapasoft/emark/app/ui/photo/PhotoActivity;", "bindWelcomeActivity", "Lkz/sapasoft/emark/app/ui/welcome/WelcomeActivity;", "app_release"}, k = 1, mv = {1, 1, 16})
@Module
/* compiled from: ActivityBuilder.kt */
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {MainActivityProviders.class})
    public abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    public abstract PhotoActivity bindPhotoActivity();

    @ContributesAndroidInjector
    public abstract WelcomeActivity bindWelcomeActivity();
}
