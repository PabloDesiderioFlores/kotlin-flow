package ar.com.pabloflores.data.cloudentity.mapper

import ar.com.pabloflores.data.cloudentity.HouseEntity
import ar.com.pabloflores.domain.model.House

/**
 * Created by Pablo Flores on 11/11/19.
 */
class HouseDataMapper {
    fun asDomainModel(houses: List<HouseEntity>): List<House> {
        return houses.map {
            House(
                id = it.id,
                name = it.name,
                mascot = it.mascot,
                headOfHouse = it.headOfHouse,
                houseGhost = it.houseGhost,
                founder = it.founder,
                school = it.school,
                values = it.values
            )
        }
    }
}