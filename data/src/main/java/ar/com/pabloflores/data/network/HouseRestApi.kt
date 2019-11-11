package ar.com.pabloflores.data.network

import ar.com.pabloflores.data.cloudentity.HouseEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
interface HouseRestApi {
    suspend fun sortingHat(): Flow<String>
    suspend fun getHouses(): Flow<List<HouseEntity>>
}