package ar.com.pabloflores.harrypotter.di.builder

import androidx.lifecycle.ViewModel
import ar.com.pabloflores.harrypotter.di.qualifier.ViewModelKey
import ar.com.pabloflores.harrypotter.ui.viewmodel.CharacterViewModel
import ar.com.pabloflores.harrypotter.ui.viewmodel.HouseInfoViewModel
import ar.com.pabloflores.harrypotter.ui.viewmodel.SortingHatViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Pablo Flores on 04/11/19.
 */
@ExperimentalCoroutinesApi
@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(SortingHatViewModel::class)
    abstract fun bindHouseViewModel(sortingHatViewModel: SortingHatViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun bindCharacterViewModel(characterViewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HouseInfoViewModel::class)
    abstract fun bindHouseInfoViewModel(houseInfoViewModel: HouseInfoViewModel): ViewModel
}