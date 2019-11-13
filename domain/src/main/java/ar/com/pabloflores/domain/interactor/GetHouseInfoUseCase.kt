package ar.com.pabloflores.domain.interactor

import ar.com.pabloflores.domain.BaseUseCase
import ar.com.pabloflores.domain.model.HouseInfo
import ar.com.pabloflores.domain.repository.CharacterRepository
import ar.com.pabloflores.domain.repository.HouseRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

/**
 * Created by Pablo Flores on 08/11/19.
 */
@ExperimentalCoroutinesApi
class GetHouseInfoUseCase @Inject constructor(
    private val houseRepository: HouseRepository,
    private val characterRepository: CharacterRepository
) : BaseUseCase<HouseInfo>() {

    lateinit var house: String

    override suspend fun executeOnBackground(): Flow<HouseInfo> {
        return houseRepository.getHouses()
            .filter { house -> house.any { it.name == this.house } }
            .map { it.first().values }
            .zip(characterRepository.getCharactersByHouse(house)) { values, characters ->
                HouseInfo(values, characters)
            }
    }

    fun config(house: String) {
        this.house = house
    }
}