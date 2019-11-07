package ar.com.pabloflores.data.repository

import ar.com.pabloflores.data.cloudentity.mapper.CharacterDataMapper
import ar.com.pabloflores.data.datasource.CharacterDataStore
import ar.com.pabloflores.domain.model.Character
import ar.com.pabloflores.domain.repository.CharacterRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
class CharacterRepositoryImpl @Inject constructor(
    private val dataStore: CharacterDataStore,
    private val mapper: CharacterDataMapper
) : CharacterRepository {
    @ExperimentalCoroutinesApi
    override suspend fun getCharactersByHouse(house: String): Flow<List<Character>> {
        return dataStore.getCharacterByHouse(house).map {
            mapper.asDomainModel(it)
        }
    }
}