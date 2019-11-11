package ar.com.pabloflores.harrypotter.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.pabloflores.data.exception.ErrorHandler
import ar.com.pabloflores.data.exception.response.ErrorModel
import ar.com.pabloflores.domain.interactor.GetHouseInfoUseCase
import ar.com.pabloflores.domain.model.HouseInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by Pablo Flores on 11/11/19.
 */
@ExperimentalCoroutinesApi
class HouseInfoViewModel @Inject constructor(
    private val getHouseInfoUseCase: GetHouseInfoUseCase,
    private val errorHandler: ErrorHandler
) : ViewModel() {
    val houseInfo: MutableLiveData<HouseInfo> by lazy { MutableLiveData<HouseInfo>() }
    val error: MutableLiveData<Exception> by lazy { MutableLiveData<Exception>() }

    fun getHouseInfo(house: String) {
        getHouseInfoUseCase.config(house)
        getHouseInfoUseCase.execute {
            onComplete {
                runBlocking {
                    it.collect {
                        houseInfo.value = it
                    }
                }
            }

            onError {
                error.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getHouseInfoUseCase.unsubscribe()
    }
}