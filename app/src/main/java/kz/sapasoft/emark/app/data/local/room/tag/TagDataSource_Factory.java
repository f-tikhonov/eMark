package kz.sapasoft.emark.app.data.local.room.tag;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class TagDataSource_Factory implements Factory<TagDataSource> {
    private final Provider<TagDao> tagDaoProvider;

    public TagDataSource_Factory(Provider<TagDao> provider) {
        this.tagDaoProvider = provider;
    }

    public TagDataSource get() {
        return newInstance(this.tagDaoProvider.get());
    }

    public static TagDataSource_Factory create(Provider<TagDao> provider) {
        return new TagDataSource_Factory(provider);
    }

    public static TagDataSource newInstance(TagDao tagDao) {
        return new TagDataSource(tagDao);
    }
}
