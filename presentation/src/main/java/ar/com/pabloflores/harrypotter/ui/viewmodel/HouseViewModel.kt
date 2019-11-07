package ar.com.pabloflores.harrypotter.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.pabloflores.data.exception.ErrorHandler
import ar.com.pabloflores.data.exception.response.ErrorModel
import ar.com.pabloflores.domain.interactor.GetHouseUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * Created by Pablo Flores on 04/11/19.
 */
@ExperimentalCoroutinesApi
class HouseViewModel @Inject constructor(
    private val getHouseUseCase: GetHouseUseCase,
    private val errorHandler: ErrorHandler
) : ViewModel() {
    val house: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    fun getHouse() {
        getHouseUseCase.execute {
            onComplete {
                runBlocking {
                    it.collect {
                        house.value = it
                    }
                }
            }
            onError { throwable ->
                val errorModel = errorHandler.handleError(throwable)
                error.value = errorModel
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getHouseUseCase.unsubscribe()
    }
}