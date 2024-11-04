package kz.sapasoft.emark.app.data.local.room.marker_sync;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class MarkerSyncDataSource_Factory implements Factory<MarkerSyncDataSource> {
    private final Provider<MarkerSyncDao> markerDaoProvider;

    public MarkerSyncDataSource_Factory(Provider<MarkerSyncDao> provider) {
        this.markerDaoProvider = provider;
    }

    public MarkerSyncDataSource get() {
        return newInstance(this.markerDaoProvider.get());
    }

    public static MarkerSyncDataSource_Factory create(Provider<MarkerSyncDao> provider) {
        return new MarkerSyncDataSource_Factory(provider);
    }

    public static MarkerSyncDataSource newInstance(MarkerSyncDao markerSyncDao) {
        return new MarkerSyncDataSource(markerSyncDao);
    }
}
