package ar.com.pabloflores.data.datasource

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 04/11/19.
 */
interface HouseDataStore {
    @ExperimentalCoroutinesApi
    suspend fun getHouse(): Flow<String>
}