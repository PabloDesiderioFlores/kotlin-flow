package ar.com.pabloflores.data.datasource

import ar.com.pabloflores.data.network.HouseRestApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 04/11/19.
 */
class HouseCloudDataStore @Inject constructor(
    private val houseRestApi: HouseRestApi
) : HouseDataStore {
    @ExperimentalCoroutinesApi
    override suspend fun getHouse(): Flow<String> {
        return houseRestApi.getHouse()
    }
}