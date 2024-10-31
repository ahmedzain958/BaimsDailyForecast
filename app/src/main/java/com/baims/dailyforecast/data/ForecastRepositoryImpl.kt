package com.baims.dailyforecast.data

import android.content.Context
import com.baims.dailyforecast.data.di.IODispatcher
import com.baims.dailyforecast.data.local.model.LocalCity
import com.baims.dailyforecast.data.remote.ForecastApiService
import com.baims.dailyforecast.data.remote.model.WeatherResponse
import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.domain.model.WeatherDataEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class ForecastRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    @Named("CitiesRetrofit") private val apiService: ForecastApiService,
    @IODispatcher private val dispatcher: CoroutineDispatcher,
) : ForecastRepository {
    override suspend fun getForecastList(
        lat: Double,
        lon: Double,
    ): List<WeatherDataEntity> {
        return withContext(dispatcher) {
            try {
                val response = apiService.getForecast(lat, lon)
                mapToDomainModel(response)
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

    private fun mapToDomainModel(forecastResponse: WeatherResponse): List<WeatherDataEntity> {
        return forecastResponse.list.orEmpty().map { forecastItem ->
            WeatherDataEntity(
                temperature = forecastItem?.main?.temp ?: 0.0,
                humidity = forecastItem?.main?.humidity ?: 0,
                description = forecastItem?.weather?.firstOrNull()?.description.orEmpty(),
                dateTime = forecastItem?.dtTxt.orEmpty(),
            )
        }
    }
}