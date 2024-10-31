package com.baims.dailyforecast.domain

import com.baims.dailyforecast.data.local.model.LocalGym
import com.baims.dailyforecast.data.remote.model.RemoteGym
import com.baims.dailyforecast.domain.model.Gym

interface GymsRepository {
    suspend fun toggleFavouriteGym(gymId: Int, favouriteState: Boolean): List<LocalGym>
    suspend fun getGyms(): List<Gym>
    suspend fun loadGyms(): List<LocalGym>
    suspend fun getGymById(id: Int): Map<String, RemoteGym>
}
