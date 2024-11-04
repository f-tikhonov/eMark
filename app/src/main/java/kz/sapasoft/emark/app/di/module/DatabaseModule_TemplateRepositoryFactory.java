package kz.sapasoft.emark.app.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kz.sapasoft.emark.app.data.local.room.template.TemplateDao;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;

public final class DatabaseModule_TemplateRepositoryFactory implements Factory<TemplateRepository> {
    private final DatabaseModule module;
    private final Provider<TemplateDao> templateDaoProvider;

    public DatabaseModule_TemplateRepositoryFactory(DatabaseModule databaseModule, Provider<TemplateDao> provider) {
        this.module = databaseModule;
        this.templateDaoProvider = provider;
    }

    public TemplateRepository get() {
        return templateRepository(this.module, this.templateDaoProvider.get());
    }

    public static DatabaseModule_TemplateRepositoryFactory create(DatabaseModule databaseModule, Provider<TemplateDao> provider) {
        return new DatabaseModule_TemplateRepositoryFactory(databaseModule, provider);
    }

    public static TemplateRepository templateRepository(DatabaseModule databaseModule, TemplateDao templateDao) {
        return (TemplateRepository) Preconditions.checkNotNull(databaseModule.templateRepository(templateDao), "Cannot return null from a non-@Nullable @Provides method");
    }
}
