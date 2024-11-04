package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.tag.TagDao;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;

public final class DatabaseModule_TagRepositoryFactory implements Factory<TagRepository> {
    private final DatabaseModule module;
    private final Provider<TagDao> tagDaoProvider;

    public DatabaseModule_TagRepositoryFactory(DatabaseModule databaseModule, Provider<TagDao> provider) {
        this.module = databaseModule;
        this.tagDaoProvider = provider;
    }

    public TagRepository get() {
        return tagRepository(this.module, this.tagDaoProvider.get());
    }

    public static DatabaseModule_TagRepositoryFactory create(DatabaseModule databaseModule, Provider<TagDao> provider) {
        return new DatabaseModule_TagRepositoryFactory(databaseModule, provider);
    }

    public static TagRepository tagRepository(DatabaseModule databaseModule, TagDao tagDao) {
        return (TagRepository) Preconditions.checkNotNull(databaseModule.tagRepository(tagDao), "Cannot return null from a non-@Nullable @Provides method");
    }
}
