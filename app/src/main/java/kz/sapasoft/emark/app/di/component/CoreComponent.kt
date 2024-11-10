package kz.sapasoft.emark.app.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kz.sapasoft.emark.app.core.App
import kz.sapasoft.emark.app.di.builder.ActivityBuilder
import kz.sapasoft.emark.app.di.module.ContextModule
import kz.sapasoft.emark.app.di.module.DatabaseModule
import kz.sapasoft.emark.app.di.module.NetworkModule
import kz.sapasoft.emark.app.di.module.PrefsModule
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class, ContextModule::class, DatabaseModule::class, PrefsModule::class])
@Singleton
interface CoreComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }
}
