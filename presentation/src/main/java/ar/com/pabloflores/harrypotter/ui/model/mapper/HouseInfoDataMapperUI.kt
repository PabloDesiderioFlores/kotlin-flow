package ar.com.pabloflores.harrypotter.ui.model.mapper

import ar.com.pabloflores.domain.model.Character
import ar.com.pabloflores.domain.model.HouseInfo
import ar.com.pabloflores.harrypotter.ui.model.CharacterUI
import ar.com.pabloflores.harrypotter.ui.model.HouseInfoUI
import ar.com.pabloflores.harrypotter.ui.model.ValuesUI

/**
 * Created by Pablo Flores on 14/11/19.
 */
class HouseInfoDataMapperUI {
    fun asUiModel(houseInfo: HouseInfo): HouseInfoUI {
        return HouseInfoUI(
            transformValues(houseInfo.values),
            transformCharacters(houseInfo.characters)
        )
    }

    private fun transformValues(values: List<String>): List<ValuesUI> {
        return values.map {
            ValuesUI(
                values = it
            )
        }
    }

    private fun transformCharacters(characters: List<Character>): List<CharacterUI> {
        return characters.map {
            CharacterUI(
                id = it.id,
                bloodStatus = it.bloodStatus,
                house = it.house,
                name = it.name,
                role = it.role,
                school = it.school
            )
        }
    }
}