package com.baims.dailyforecast.domain

import com.baims.dailyforecast.data.local.model.LocalCity
import com.baims.dailyforecast.data.remote.model.RemoteCity
import com.baims.dailyforecast.domain.model.City

interface ForecastRepository {
    suspend fun getCities(): List<City>
    suspend fun loadCities(): List<LocalCity>
    suspend fun getCityById(id: Int): Map<String, RemoteCity>
}
