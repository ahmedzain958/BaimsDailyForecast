package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.WeatherDataEntity
import javax.inject.Inject

class GetForecastListUseCase @Inject constructor(
    private val repository: ForecastRepository,
) {
    suspend operator fun invoke(lat: Double, lon: Double): List<WeatherDataEntity> {
        repository.loadForecastList(lat, lon)
        return repository.getForecastList(lat, lon)
    }
}