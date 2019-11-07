package ar.com.pabloflores.data.network.retrofit

import ar.com.pabloflores.data.cloudentity.CharacterEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pablo Flores on 30/10/19.
 */
interface CharacterApi {
    @ExperimentalCoroutinesApi
    @GET("characters")
    suspend fun getCharactersByHouse(
        @Query("key") key: String,
        @Query("house") house: String,
        @Query("role") role: String
    ): List<CharacterEntity>
}