package ar.com.pabloflores.data.datasource

import ar.com.pabloflores.data.cloudentity.CharacterEntity
import ar.com.pabloflores.data.network.CharacterRestApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 05/11/19.
 */
class CharacterCloudDataStore @Inject constructor(
    private val characterRestApi: CharacterRestApi
) : CharacterDataStore {
    @ExperimentalCoroutinesApi
    override suspend fun getCharacterByHouse(house: String): Flow<List<CharacterEntity>> {
        return characterRestApi.getCharacterByHouse(house)
    }
}