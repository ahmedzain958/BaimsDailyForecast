package com.baims.dailyforecast.data

import android.content.Context
import com.baims.dailyforecast.data.di.IODispatcher
import com.baims.dailyforecast.data.local.WeatherDao
import com.baims.dailyforecast.data.local.model.LocalCity
import com.baims.dailyforecast.data.local.model.forecast.LocalWeatherData
import com.baims.dailyforecast.data.remote.ForecastApiService
import com.baims.dailyforecast.data.remote.model.WeatherResponse
import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.domain.model.WeatherEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val apiService: ForecastApiService,
    private val weatherDao: WeatherDao,
    @IODispatcher private val dispatcher: CoroutineDispatcher,
) : ForecastRepository {

    private suspend fun insertIntoLocalDatabase(
        cityId: Int,
        cityName: String,
        lat: Double,
        lon: Double,
    ) {
        val weatherResponse: WeatherResponse = apiService.getForecast(lat, lon)
        weatherDao.addAll(weatherResponse.dailyWeatherItems.map {
            LocalWeatherData(
                cityId = cityId,
                cityNameEn = cityName,
                temperature = it.main?.temp ?: 0.0,
                humidity = it.main?.humidity ?: 0,
                description = it.weather?.firstOrNull()?.description.orEmpty(),
                dateTime = it.dtTxt.orEmpty())
        })
    }

    override suspend fun saveForecastList(cityId: Int, cityName: String,
                                          lat: Double, lon: Double) =
        withContext(dispatcher) {
            try {
                insertIntoLocalDatabase(cityId, cityName, lat, lon)
            } catch (e: Exception) {
                if (weatherDao.getWeatherByCity(cityId).isEmpty())
                    throw Exception("Something went wrong. try connecting to internet")
            }
        }

    override suspend fun getForecastList(cityId: Int,
        lat: Double,
        lon: Double,
    ): List<WeatherEntity> {
        return withContext(dispatcher) {
            try {
                val weatherDaoList = weatherDao.getWeatherByCity(cityId)
                mapToDomainModel(weatherDaoList)
            } catch (e: Exception) {
                val exception = e.message
                emptyList()
            }
        }
    }

    override suspend fun getCities(): List<City> = withContext(dispatcher) {
        val json = context.assets.open("cities.json").bufferedReader().use { it.readText() }
        val listType = object : TypeToken<List<LocalCity>>() {}.type
        val localCities: List<LocalCity> = Gson().fromJson(json, listType)
        return@withContext localCities.map {
            City(
                id = it.id,
                cityNameAr = it.cityNameAr,
                cityNameEn = it.cityNameEn,
                lat = it.lat,
                lon = it.lon
            )
        }
    }

    private fun mapToDomainModel(localWeatherData: List<LocalWeatherData>): List<WeatherEntity> {
        return localWeatherData.map {
            WeatherEntity(
                temperature = it.temperature,
                humidity = it.humidity,
                weather = emptyList(),
                dateTime = it.dateTime
            )
        }
    }
}