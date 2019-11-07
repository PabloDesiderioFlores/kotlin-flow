package ar.com.pabloflores.data.network

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 30/10/19.
 */
interface HouseRestApi {
    @ExperimentalCoroutinesApi
    suspend fun getHouse(): Flow<String>
}