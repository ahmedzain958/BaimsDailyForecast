package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.data.GymsRepositoryImpl
import com.baims.dailyforecast.data.remote.model.RemoteGym
import javax.inject.Inject

class GetGymsByIdUseCase @Inject constructor(private val gymsRepositoryImpl: GymsRepositoryImpl) {
    suspend operator fun invoke(id: Int): Map<String, RemoteGym> {
        return gymsRepositoryImpl.getGymById(id)
    }
}