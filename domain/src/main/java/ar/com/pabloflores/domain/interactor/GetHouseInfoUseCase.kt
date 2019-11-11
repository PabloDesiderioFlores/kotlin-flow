package ar.com.pabloflores.domain.interactor

import ar.com.pabloflores.domain.BaseUseCase
import ar.com.pabloflores.domain.model.HouseInfo
import ar.com.pabloflores.domain.repository.CharacterRepository
import ar.com.pabloflores.domain.repository.HouseRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Pablo Flores on 08/11/19.
 */
class GetHouseInfoUseCase @Inject constructor(
    private val houseRepository: HouseRepository,
    private val characterRepository: CharacterRepository
) : BaseUseCase<HouseInfo>() {

    lateinit var house: String

    override suspend fun executeOnBackground(): Flow<HouseInfo> {

        val values = flowOf(
            houseRepository.getHouses()
                .filter { house -> house.any { it.name == this.house } }
                .first()[0].values
        )

        val characters = characterRepository.getCharactersByHouse(house)

        return values.zip(characters) { house, character -> HouseInfo(house, character) }
    }

    fun config(house: String) {
        this.house = house
    }
}