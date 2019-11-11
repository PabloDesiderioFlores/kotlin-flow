package ar.com.pabloflores.harrypotter.di.builder

import androidx.lifecycle.ViewModelProvider
import ar.com.pabloflores.harrypotter.ui.viewmodel.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Pablo Flores on 04/11/19.
 */
@ExperimentalCoroutinesApi
@Module(includes = [ViewModelBuilder::class])
abstract class ViewModelFactoryBuilder {
    @Binds
    abstract fun bindViewModelFactoryBuilder(ViewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}