package com.baims.dailyforecast.domain

import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.domain.model.WeatherEntity

interface ForecastRepository {
    suspend fun saveForecastList(cityId: Int, cityName: String, lat: Double, lon: Double)

    suspend fun getForecastList(cityId: Int,lat: Double, lon: Double)
    : List<WeatherEntity>

    suspend fun getCities(): List<City>

}
