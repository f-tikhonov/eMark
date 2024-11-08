package kz.sapasoft.emark.app.ui.photo;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import kz.sapasoft.emark.app.di.builder.ActivityBuilder_BindPhotoActivity;

import javax.inject.Provider;

public final class PhotoActivity_MembersInjector implements MembersInjector<PhotoActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public PhotoActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<PhotoActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new PhotoActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(PhotoActivity photoActivity) {
        DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(photoActivity, this.androidInjectorProvider.get());
        injectViewModelFactory(photoActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(PhotoActivity photoActivity, ViewModelProvider.Factory factory) {
        photoActivity.viewModelFactory = (ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory) factory;
    }
}
