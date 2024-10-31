package com.baims.dailyforecast.data

import com.baims.dailyforecast.data.di.IODispatcher
import com.baims.dailyforecast.data.local.CitiesDao
import com.baims.dailyforecast.data.local.model.LocalCity
import com.baims.dailyforecast.data.remote.GymsApiService
import com.baims.dailyforecast.data.remote.model.RemoteCity
import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.City
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastRepositoryImpl @Inject constructor(
    private val apiService: GymsApiService,
    private val citiesDao: CitiesDao,
    @IODispatcher private val dispatcher: CoroutineDispatcher,
) : ForecastRepository {
    override suspend fun getCities(): List<City> {
        return withContext(dispatcher) {
            return@withContext citiesDao.getAll().map {
                City(it.cityNameAr, it.cityNameEn, it.id, it.lat, it.lon)
            }
        }

    }

    override suspend fun loadCities() = withContext(dispatcher) {
        try {
            updateLocalDatabase()
        } catch (e: Exception) {
            if (citiesDao.getAll().isEmpty())
                throw Exception("Something went wrong. try connecting to internet")
        }
        citiesDao.getAll()
    }

    private suspend fun updateLocalDatabase() {
        val cities = apiService.getCities().filter {
            it.lat != null && it.lon != null
        }
        citiesDao.addAll(cities.map {
            LocalCity(
                it.id ?: 0,
                it.cityNameAr ?: "",
                it.cityNameEn ?: "",
                it.lat ?: 0.0,
                it.lon ?: 0.0
            )
        })

    }

    override suspend fun getCityById(id: Int) = withContext(dispatcher) {
        emptyMap<String, RemoteCity>()
    }


}