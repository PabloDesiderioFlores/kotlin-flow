package ar.com.pabloflores.harrypotter.di.builder

import androidx.lifecycle.ViewModel
import ar.com.pabloflores.harrypotter.di.qualifier.ViewModelKey
import ar.com.pabloflores.harrypotter.ui.viewmodel.CharacterViewModel
import ar.com.pabloflores.harrypotter.ui.viewmodel.HouseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Pablo Flores on 04/11/19.
 */
@Module
abstract class ViewModelBuilder {
    @ExperimentalCoroutinesApi
    @Binds
    @IntoMap
    @ViewModelKey(HouseViewModel::class)
    abstract fun binHouseViewModel(houseViewModel: HouseViewModel): ViewModel

    @ExperimentalCoroutinesApi
    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun binCharacterViewModel(characterViewModel: CharacterViewModel): ViewModel
}