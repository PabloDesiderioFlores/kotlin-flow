package ar.com.pabloflores.data.network

import ar.com.pabloflores.data.Config
import ar.com.pabloflores.data.cloudentity.CharacterEntity
import ar.com.pabloflores.data.network.retrofit.CharacterApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
class CharacterRestApiImpl @Inject constructor(
    private val characterApi: CharacterApi
) : CharacterRestApi {
    @ExperimentalCoroutinesApi
    override suspend fun getCharacterByHouse(house: String): Flow<List<CharacterEntity>> {
        return flow {
            emit(characterApi.getCharactersByHouse(Config.API_KEY, house, "student"))
        }
    }
}