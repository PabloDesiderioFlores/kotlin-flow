package ar.com.pabloflores.data.datasource

import ar.com.pabloflores.data.cloudentity.HouseEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 04/11/19.
 */
@ExperimentalCoroutinesApi
interface HouseDataStore {
    suspend fun sortingHat(): Flow<String>
    suspend fun getHouses(): Flow<List<HouseEntity>>
}