package ar.com.pabloflores.domain.repository

import kotlinx.coroutines.flow.Flow
import ar.com.pabloflores.domain.model.Character

/**
 * Created by Pablo Flores on 30/10/19.
 */
interface CharacterRepository {
    suspend fun getCharactersByHouse(house: String): Flow<List<Character>>
}