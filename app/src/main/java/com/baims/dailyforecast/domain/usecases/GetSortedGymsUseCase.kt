package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.data.GymsRepositoryImpl
import com.baims.dailyforecast.domain.model.Gym
import javax.inject.Inject

class GetSortedGymsUseCase @Inject constructor(private val gymsRepositoryImpl : GymsRepositoryImpl) {


    suspend operator fun invoke(): List<Gym> {
        return gymsRepositoryImpl.getGyms().sortedBy {
            it.name
        }
    }
}