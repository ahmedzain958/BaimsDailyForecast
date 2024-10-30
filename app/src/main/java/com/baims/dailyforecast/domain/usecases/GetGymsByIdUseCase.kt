package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.data.GymsRepository
import com.baims.dailyforecast.data.remote.RemoteGym
import javax.inject.Inject

class GetGymsByIdUseCase @Inject constructor(private val gymsRepository: GymsRepository) {
    suspend operator fun invoke(id: Int): Map<String, RemoteGym> {
        return gymsRepository.getGymById(id)
    }
}