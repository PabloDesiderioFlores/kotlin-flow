package ar.com.pabloflores.harrypotter.di.module

import android.app.Application
import android.content.Context
import ar.com.pabloflores.harrypotter.di.builder.ViewModelFactoryBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pablo Flores on 04/11/19.
 */
@Module(includes = [ViewModelFactoryBuilder::class])
class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}