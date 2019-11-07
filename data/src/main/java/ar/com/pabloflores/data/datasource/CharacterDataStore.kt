package ar.com.pabloflores.data.datasource

import ar.com.pabloflores.data.cloudentity.CharacterEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 05/11/19.
 */
interface CharacterDataStore {
    @ExperimentalCoroutinesApi
    suspend fun getCharacterByHouse(house: String): Flow<List<CharacterEntity>>
}