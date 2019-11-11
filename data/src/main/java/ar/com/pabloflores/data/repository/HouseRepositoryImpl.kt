package ar.com.pabloflores.data.repository

import ar.com.pabloflores.data.cloudentity.mapper.HouseDataMapper
import ar.com.pabloflores.data.datasource.HouseDataStore
import ar.com.pabloflores.domain.model.House
import ar.com.pabloflores.domain.repository.HouseRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
class HouseRepositoryImpl @Inject constructor(
    private val dataStore: HouseDataStore,
    private val houseDataMapper: HouseDataMapper
) : HouseRepository {
    override suspend fun getHouses(): Flow<List<House>> {
        return dataStore.getHouses().map {
            houseDataMapper.asDomainModel(it)
        }
    }

    override suspend fun sortingHat(): Flow<String> {
        return dataStore.sortingHat()
    }
}