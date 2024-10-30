package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.data.GymsRepository
import com.baims.dailyforecast.domain.Gym
import javax.inject.Inject

class GetInitialGymsUseCase @Inject constructor(
    private val gymsRepository: GymsRepository,
    private val getSortedGymsUseCase: GetSortedGymsUseCase,
) {


    suspend operator fun invoke(): List<Gym> {
        gymsRepository.loadGyms()
        return getSortedGymsUseCase()
    }
}