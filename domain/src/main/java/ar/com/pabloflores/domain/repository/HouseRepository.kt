package ar.com.pabloflores.domain.repository

import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 30/10/19.
 */
interface HouseRepository {
    suspend fun getHouse(): Flow<String>
}