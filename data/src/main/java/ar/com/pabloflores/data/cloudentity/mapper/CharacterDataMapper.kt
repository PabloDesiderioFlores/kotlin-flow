package ar.com.pabloflores.data.cloudentity.mapper

import ar.com.pabloflores.data.cloudentity.CharacterEntity
import ar.com.pabloflores.domain.model.Character

/**
 * Created by Pablo Flores on 05/11/19.
 */
class CharacterDataMapper {
    fun asDomainModel(characters: List<CharacterEntity>): List<Character> {
        return characters.map {
            Character(
                id = it.id,
                name = it.name,
                role = it.role,
                house = it.house,
                school = it.school,
                bloodStatus = it.bloodStatus
            )
        }
    }
}