package kz.sapasoft.emark.app.ui;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider;

    public ViewModelFactory_Factory(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.creatorsProvider = provider;
    }

    public ViewModelFactory get() {
        return newInstance(this.creatorsProvider.get());
    }

    public static ViewModelFactory_Factory create(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new ViewModelFactory_Factory(provider);
    }

    public static ViewModelFactory newInstance(Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return new ViewModelFactory(map);
    }
}
