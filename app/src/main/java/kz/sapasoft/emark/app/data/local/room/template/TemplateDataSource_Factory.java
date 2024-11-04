package kz.sapasoft.emark.app.data.local.room.template;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class TemplateDataSource_Factory implements Factory<TemplateDataSource> {
    private final Provider<TemplateDao> templateDaoProvider;

    public TemplateDataSource_Factory(Provider<TemplateDao> provider) {
        this.templateDaoProvider = provider;
    }

    public TemplateDataSource get() {
        return newInstance(this.templateDaoProvider.get());
    }

    public static TemplateDataSource_Factory create(Provider<TemplateDao> provider) {
        return new TemplateDataSource_Factory(provider);
    }

    public static TemplateDataSource newInstance(TemplateDao templateDao) {
        return new TemplateDataSource(templateDao);
    }
}
