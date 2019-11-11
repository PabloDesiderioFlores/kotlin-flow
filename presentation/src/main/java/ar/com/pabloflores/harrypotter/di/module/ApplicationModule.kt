package ar.com.pabloflores.harrypotter.di.module

import ar.com.pabloflores.data.Config
import ar.com.pabloflores.data.cloudentity.mapper.CharacterDataMapper
import ar.com.pabloflores.data.cloudentity.mapper.HouseDataMapper
import ar.com.pabloflores.data.datasource.CharacterCloudDataStore
import ar.com.pabloflores.data.datasource.CharacterDataStore
import ar.com.pabloflores.data.datasource.HouseCloudDataStore
import ar.com.pabloflores.data.datasource.HouseDataStore
import ar.com.pabloflores.data.exception.ErrorHandler
import ar.com.pabloflores.data.network.CharacterRestApi
import ar.com.pabloflores.data.network.CharacterRestApiImpl
import ar.com.pabloflores.data.network.HouseRestApi
import ar.com.pabloflores.data.network.HouseRestApiImpl
import ar.com.pabloflores.data.network.retrofit.CharacterApi
import ar.com.pabloflores.data.network.retrofit.HouseApi
import ar.com.pabloflores.data.repository.CharacterRepositoryImpl
import ar.com.pabloflores.data.repository.HouseRepositoryImpl
import ar.com.pabloflores.domain.repository.CharacterRepository
import ar.com.pabloflores.domain.repository.HouseRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
@Module(includes = [AndroidInjectionModule::class])
class ApplicationModule {
    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            //  .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addNetworkInterceptor(interceptor)
        return client.build()
    }


    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    //region rest api
    @Provides
    @Singleton
    fun providesHouseAPI(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): HouseApi {
        val retrofit = Retrofit.Builder().baseUrl(Config.HOST)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
        return retrofit.create(HouseApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCharacterAPI(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): CharacterApi {
        val retrofit = Retrofit.Builder().baseUrl(Config.HOST)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
        return retrofit.create(CharacterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHouseRestApi(houseRestApiImpl: HouseRestApiImpl): HouseRestApi {
        return houseRestApiImpl
    }

    @Provides
    @Singleton
    fun providesCharacterRestApi(characterRestApiImpl: CharacterRestApiImpl): CharacterRestApi {
        return characterRestApiImpl
    }

    //region repository
    @Provides
    @Singleton
    fun provideHouseRepository(houseRepositoryImpl: HouseRepositoryImpl): HouseRepository {
        return houseRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository {
        return characterRepositoryImpl
    }

    //region data store
    @Provides
    @Singleton
    fun providesHouseDataStore(houseRestApi: HouseRestApi): HouseDataStore {
        return HouseCloudDataStore(houseRestApi)
    }

    @Provides
    @Singleton
    fun provideCharacterDataStore(characterRestApi: CharacterRestApi): CharacterDataStore {
        return CharacterCloudDataStore(characterRestApi)
    }

    //region mapper
    @Provides
    fun provideCharacterDataMapper(): CharacterDataMapper {
        return CharacterDataMapper()
    }

    @Provides
    fun provideHouseInfoDataMapper(): HouseDataMapper {
        return HouseDataMapper()
    }

    //region error handler
    @Provides
    @Singleton
    fun provideErrorCloudHandler(): ErrorHandler {
        return ErrorHandler()
    }
}