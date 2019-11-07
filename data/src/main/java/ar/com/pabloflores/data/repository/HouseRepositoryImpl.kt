package ar.com.pabloflores.data.repository

import ar.com.pabloflores.data.datasource.HouseDataStore
import ar.com.pabloflores.domain.repository.HouseRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
class HouseRepositoryImpl @Inject constructor(
    private val dataStore: HouseDataStore
) : HouseRepository {
    override suspend fun getHouse(): Flow<String> {
        return dataStore.getHouse()
    }
}