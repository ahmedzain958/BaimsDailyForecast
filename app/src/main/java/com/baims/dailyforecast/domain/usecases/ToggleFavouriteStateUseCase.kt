package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.data.GymsRepositoryImpl
import com.baims.dailyforecast.domain.model.Gym
import javax.inject.Inject

class ToggleFavouriteStateUseCase @Inject constructor(
    private val gymsRepositoryImpl: GymsRepositoryImpl,
    private val getSortedGymsUseCase: GetSortedGymsUseCase,
) {

    suspend operator fun invoke(id: Int, oldState: Boolean): List<Gym> {
        val newState = oldState.not()
        gymsRepositoryImpl.toggleFavouriteGym(id, newState)
        return getSortedGymsUseCase()
    }
}