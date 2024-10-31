package com.baims.dailyforecast.domain

import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.domain.model.WeatherDataEntity

interface ForecastRepository {
    suspend fun getForecastList(lat: Double, lon: Double)
    : List<WeatherDataEntity>
    suspend fun getCities(): List<City>

}
