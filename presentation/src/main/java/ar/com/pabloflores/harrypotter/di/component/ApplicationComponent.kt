package ar.com.pabloflores.harrypotter.di.component

import android.app.Application
import ar.com.pabloflores.harrypotter.AndroidApplication
import ar.com.pabloflores.harrypotter.di.module.ActivityBindingModule
import ar.com.pabloflores.harrypotter.di.module.ApplicationModule
import ar.com.pabloflores.harrypotter.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Pablo Flores on 30/10/19.
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class,
        ActivityBindingModule::class, ContextModule::class]
)
interface ApplicationComponent : AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}