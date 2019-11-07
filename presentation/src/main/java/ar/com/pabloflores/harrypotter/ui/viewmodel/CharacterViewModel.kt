package ar.com.pabloflores.harrypotter.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.pabloflores.data.exception.ErrorHandler
import ar.com.pabloflores.data.exception.response.ErrorModel
import ar.com.pabloflores.domain.interactor.GetCharactersUseCase
import ar.com.pabloflores.domain.model.Character
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * Created by Pablo Flores on 06/11/19.
 */
@ExperimentalCoroutinesApi
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val errorHandler: ErrorHandler
) : ViewModel() {
    val characters: MutableLiveData<List<Character>> by lazy { MutableLiveData<List<Character>>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }


    fun getCharactersByHouse(house: String) {
        getCharactersUseCase.config(house)
        getCharactersUseCase.execute {
            onComplete {
                runBlocking {
                    it.collect {
                        characters.value = it
                    }
                }
            }
            onError {
                val errorModel = errorHandler.handleError(it)
                error.value = errorModel
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getCharactersUseCase.unsubscribe()
    }
}