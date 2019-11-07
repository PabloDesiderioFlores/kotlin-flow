package ar.com.pabloflores.data.network

import ar.com.pabloflores.data.network.retrofit.HouseApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
class HouseRestApiImpl @Inject constructor(
    private val api: HouseApi
) : HouseRestApi {
    @ExperimentalCoroutinesApi
    override suspend fun getHouse(): Flow<String> {
        return flow {
            emit(api.getHouse())
        }
    }
}