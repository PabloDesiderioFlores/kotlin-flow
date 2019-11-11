package ar.com.pabloflores.data.network.retrofit

import ar.com.pabloflores.data.cloudentity.HouseEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
interface HouseApi {
    @GET("sortingHat")
    suspend fun sortingHat(): String

    @GET("houses")
    suspend fun getHouses(@Query("key") key: String): List<HouseEntity>
}