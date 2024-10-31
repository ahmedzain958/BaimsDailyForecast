package com.baims.dailyforecast.domain

import com.baims.dailyforecast.domain.model.City

interface ForecastRepository {
    suspend fun getCities(): List<City>
}
