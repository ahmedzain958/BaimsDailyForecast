package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.data.GymsRepository
import com.baims.dailyforecast.domain.Gym
import javax.inject.Inject

class ToggleFavouriteStateUseCase @Inject constructor(
    private val gymsRepository: GymsRepository,
    private val getSortedGymsUseCase: GetSortedGymsUseCase,
) {

    suspend operator fun invoke(id: Int, oldState: Boolean): List<Gym> {
        val newState = oldState.not()
        gymsRepository.toggleFavouriteGym(id, newState)
        return getSortedGymsUseCase()
    }
}