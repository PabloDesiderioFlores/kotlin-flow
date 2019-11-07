package ar.com.pabloflores.data.network

import ar.com.pabloflores.data.cloudentity.CharacterEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 30/10/19.
 */
interface CharacterRestApi {
    @ExperimentalCoroutinesApi
    suspend fun getCharacterByHouse(house: String): Flow<List<CharacterEntity>>
}