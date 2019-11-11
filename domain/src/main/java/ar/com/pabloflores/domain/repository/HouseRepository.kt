package ar.com.pabloflores.domain.repository

import ar.com.pabloflores.domain.model.House
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 30/10/19.
 */
interface HouseRepository {
    suspend fun sortingHat(): Flow<String>
    suspend fun getHouses(): Flow<List<House>>
}