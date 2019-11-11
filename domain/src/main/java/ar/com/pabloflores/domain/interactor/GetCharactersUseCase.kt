package ar.com.pabloflores.domain.interactor

import ar.com.pabloflores.domain.BaseUseCase
import ar.com.pabloflores.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import ar.com.pabloflores.domain.model.Character
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseUseCase<List<Character>>() {

    lateinit var house: String

    override suspend fun executeOnBackground(): Flow<List<Character>> {
        return characterRepository.getCharactersByHouse(house)
    }

    fun config(house: String) {
        this.house = house
    }
}