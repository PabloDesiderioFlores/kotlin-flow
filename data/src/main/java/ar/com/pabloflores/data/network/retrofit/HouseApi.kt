package ar.com.pabloflores.data.network.retrofit

import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.http.GET

/**
 * Created by Pablo Flores on 30/10/19.
 */
interface HouseApi {
    @ExperimentalCoroutinesApi
    @GET("sortingHat")
    suspend fun getHouse(): String
}