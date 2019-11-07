package ar.com.pabloflores.domain.interactor

import ar.com.pabloflores.domain.BaseUseCase
import ar.com.pabloflores.domain.repository.HouseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
class GetHouseUseCase @Inject constructor(
    private val houseRepository: HouseRepository
) : BaseUseCase<String>() {
    override suspend fun executeOnBackground(): Flow<String> {
        return houseRepository.getHouse()
    }
}