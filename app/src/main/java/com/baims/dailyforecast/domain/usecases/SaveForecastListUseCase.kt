package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.WeatherEntity
import javax.inject.Inject

class SaveForecastListUseCase @Inject constructor(
    private val repository: ForecastRepository,
) {
    suspend operator fun invoke(
        cityId: Int,
        cityName: String,
        lat: Double,
        lon: Double,
    ) {
        repository.saveForecastList(cityId, cityName, lat, lon)
    }
}