package com.baims.dailyforecast.data

import com.baims.dailyforecast.data.di.IODispatcher
import com.baims.dailyforecast.data.local.GymsDao
import com.baims.dailyforecast.data.local.model.LocalGym
import com.baims.dailyforecast.data.local.model.LocalGymFavouriteState
import com.baims.dailyforecast.data.remote.ForecastApiService
import com.baims.dailyforecast.domain.model.Gym
import com.baims.dailyforecast.domain.GymsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GymsRepositoryImpl @Inject constructor(
    private val apiService: ForecastApiService,
    private val gymDao: GymsDao,
    @IODispatcher private val dispatcher: CoroutineDispatcher
): GymsRepository {

    override suspend fun toggleFavouriteGym(gymId: Int, favouriteState: Boolean) =
        withContext(dispatcher) {
            gymDao.update(LocalGymFavouriteState(gymId, favouriteState))
            return@withContext gymDao.getAll()
        }

    override suspend fun getGyms(): List<Gym> =
        withContext(dispatcher) {
            return@withContext gymDao.getAll().map {
                Gym(it.id, it.name, it.place, it.isOpen, it.isFavorite)
            }
        }

    private suspend fun updateLocalDatabase() {
        val gyms = apiService.getGyms()
        val favouriteGymsList = gymDao.getFavouriteGyms()
        gymDao.addAll(gyms.map {
            LocalGym(it.id, it.name, it.place, it.isOpen)
        })
        gymDao.updateAll(favouriteGymsList.map { LocalGymFavouriteState(it.id, true) })
    }

    override suspend fun loadGyms() = withContext(dispatcher) {
        try {
            updateLocalDatabase()
        } catch (e: Exception) {
            if (gymDao.getAll().isEmpty())
                throw Exception("Something went wrong. try connecting to internet")
        }
        gymDao.getAll()
    }

    override suspend fun getGymById(id: Int) = withContext(dispatcher) {
        apiService.getGymById(id)
    }

}