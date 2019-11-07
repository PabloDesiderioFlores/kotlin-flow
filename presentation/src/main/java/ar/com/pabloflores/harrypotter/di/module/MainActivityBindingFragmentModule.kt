package ar.com.pabloflores.harrypotter.di.module

import ar.com.pabloflores.harrypotter.di.qualifier.PerFragment
import ar.com.pabloflores.harrypotter.ui.fragment.CharacterFragment
import ar.com.pabloflores.harrypotter.ui.fragment.SortingHatFragment
import ar.com.pabloflores.harrypotter.ui.fragment.SpellsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
@Module
abstract class MainActivityBindingFragmentModule {
    @ContributesAndroidInjector
    @PerFragment
    abstract fun spellsFragment(): SpellsFragment

    @ContributesAndroidInjector
    @PerFragment
    abstract fun sortingHat(): SortingHatFragment

    @ContributesAndroidInjector
    @PerFragment
    abstract fun CharacterFragment(): CharacterFragment

}