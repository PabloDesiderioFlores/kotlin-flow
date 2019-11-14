package ar.com.pabloflores.harrypotter.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.pabloflores.data.exception.ErrorHandler
import ar.com.pabloflores.data.exception.response.ErrorModel
import ar.com.pabloflores.domain.interactor.GetHouseInfoUseCase
import ar.com.pabloflores.harrypotter.ui.model.HouseInfoUI
import ar.com.pabloflores.harrypotter.ui.model.mapper.HouseInfoDataMapperUI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * Created by Pablo Flores on 11/11/19.
 */
@ExperimentalCoroutinesApi
class HouseInfoViewModel @Inject constructor(
    private val getHouseInfoUseCase: GetHouseInfoUseCase,
    private val errorHandler: ErrorHandler,
    private val mapper: HouseInfoDataMapperUI
) : ViewModel() {
    val houseInfo: MutableLiveData<HouseInfoUI> by lazy { MutableLiveData<HouseInfoUI>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    fun getHouseInfo(house: String) {
        getHouseInfoUseCase.config(house)
        getHouseInfoUseCase.execute {
            onComplete {
                runBlocking {
                    it.collect {
                        houseInfo.value = mapper.asUiModel(it)
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
        getHouseInfoUseCase.unsubscribe()
    }
}