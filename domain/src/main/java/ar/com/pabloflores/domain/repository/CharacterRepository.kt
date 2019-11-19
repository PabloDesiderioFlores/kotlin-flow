package ar.com.pabloflores.domain.repository

import ar.com.pabloflores.domain.model.Character
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
interface CharacterRepository {
    suspend fun getCharactersByHouse(house: String): Flow<List<Character>>
}