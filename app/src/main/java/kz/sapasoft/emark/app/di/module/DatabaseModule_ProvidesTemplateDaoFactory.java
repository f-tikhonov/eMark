package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.LocalDatabase;
import kz.sapasoft.emark.app.data.local.room.template.TemplateDao;

public final class DatabaseModule_ProvidesTemplateDaoFactory implements Factory<TemplateDao> {
    private final Provider<LocalDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvidesTemplateDaoFactory(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        this.module = databaseModule;
        this.databaseProvider = provider;
    }

    public TemplateDao get() {
        return providesTemplateDao(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvidesTemplateDaoFactory create(DatabaseModule databaseModule, Provider<LocalDatabase> provider) {
        return new DatabaseModule_ProvidesTemplateDaoFactory(databaseModule, provider);
    }

    public static TemplateDao providesTemplateDao(DatabaseModule databaseModule, LocalDatabase localDatabase) {
        return (TemplateDao) Preconditions.checkNotNull(databaseModule.providesTemplateDao(localDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
