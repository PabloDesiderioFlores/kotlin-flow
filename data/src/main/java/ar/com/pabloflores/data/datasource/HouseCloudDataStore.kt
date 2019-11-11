package ar.com.pabloflores.data.datasource

import ar.com.pabloflores.data.cloudentity.HouseEntity
import ar.com.pabloflores.data.network.HouseRestApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 04/11/19.
 */
@ExperimentalCoroutinesApi
class HouseCloudDataStore @Inject constructor(
    private val houseRestApi: HouseRestApi
) : HouseDataStore {
    override suspend fun getHouses(): Flow<List<HouseEntity>> {
        return houseRestApi.getHouses()
    }

    override suspend fun sortingHat(): Flow<String> {
        return houseRestApi.sortingHat()
    }
}