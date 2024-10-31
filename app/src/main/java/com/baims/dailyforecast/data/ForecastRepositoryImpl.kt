package com.baims.dailyforecast.data

import android.content.Context
import com.baims.dailyforecast.data.di.IODispatcher
import com.baims.dailyforecast.data.local.model.LocalCity
import com.baims.dailyforecast.data.remote.GymsApiService
import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.City
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
    private val apiService: GymsApiService,
    @IODispatcher private val dispatcher: CoroutineDispatcher,
) : ForecastRepository {
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
}