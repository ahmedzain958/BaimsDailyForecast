package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.data.GymsRepository
import com.baims.dailyforecast.domain.Gym
import javax.inject.Inject

class GetSortedGymsUseCase @Inject constructor(private val gymsRepository : GymsRepository) {


    suspend operator fun invoke(): List<Gym> {
        return gymsRepository.getGyms().sortedBy {
            it.name
        }
    }
}