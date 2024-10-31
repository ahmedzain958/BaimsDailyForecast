package com.baims.dailyforecast.domain

import com.baims.dailyforecast.data.local.model.forecast.LocalWeatherData
import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.domain.model.WeatherDataEntity

interface ForecastRepository {
    suspend fun loadForecastList(lat: Double, lon: Double)
    : List<LocalWeatherData>

    suspend fun getForecastList(lat: Double, lon: Double)
    : List<WeatherDataEntity>

    suspend fun getCities(): List<City>

}
