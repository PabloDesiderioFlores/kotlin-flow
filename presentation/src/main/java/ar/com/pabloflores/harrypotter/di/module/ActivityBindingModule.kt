package ar.com.pabloflores.harrypotter.di.module

import ar.com.pabloflores.harrypotter.di.qualifier.PerActivity
import ar.com.pabloflores.harrypotter.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Pablo Flores on 30/10/19.
 */
@Module
abstract class ActivityBindingModule {
    @ExperimentalCoroutinesApi
    @ContributesAndroidInjector(modules = [MainActivityBindingFragmentModule::class])
    @PerActivity
    abstract fun mainActivity(): MainActivity
}