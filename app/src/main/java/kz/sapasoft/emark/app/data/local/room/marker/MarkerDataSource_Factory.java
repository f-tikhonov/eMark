package kz.sapasoft.emark.app.data.local.room.marker;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class MarkerDataSource_Factory implements Factory<MarkerDataSource> {
    private final Provider<MarkerDao> markerDaoProvider;

    public MarkerDataSource_Factory(Provider<MarkerDao> provider) {
        this.markerDaoProvider = provider;
    }

    public MarkerDataSource get() {
        return newInstance(this.markerDaoProvider.get());
    }

    public static MarkerDataSource_Factory create(Provider<MarkerDao> provider) {
        return new MarkerDataSource_Factory(provider);
    }

    public static MarkerDataSource newInstance(MarkerDao markerDao) {
        return new MarkerDataSource(markerDao);
    }
}
