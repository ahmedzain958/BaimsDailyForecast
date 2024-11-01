package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.WeatherEntity
import javax.inject.Inject

class GetForecastListUseCase @Inject constructor(
    private val repository: ForecastRepository,
    private val saveForecastListUseCase: SaveForecastListUseCase
) {
    suspend operator fun invoke(cityId: Int, cityName: String, lat: Double, lon: Double): List<WeatherEntity> {
        saveForecastListUseCase.invoke(cityId, cityName, lat, lon)
        return repository.getForecastList(cityId, lat, lon)
    }
}