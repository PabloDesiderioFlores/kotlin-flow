package ar.com.pabloflores.data.network

import ar.com.pabloflores.data.Config
import ar.com.pabloflores.data.cloudentity.HouseEntity
import ar.com.pabloflores.data.network.retrofit.HouseApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
class HouseRestApiImpl @Inject constructor(
    private val api: HouseApi
) : HouseRestApi {
    override suspend fun getHouses(): Flow<List<HouseEntity>> {
        return flow {
            emit(api.getHouses(Config.API_KEY))
        }
    }

    override suspend fun sortingHat(): Flow<String> {
        return flow {
            emit(api.sortingHat())
        }
    }
}