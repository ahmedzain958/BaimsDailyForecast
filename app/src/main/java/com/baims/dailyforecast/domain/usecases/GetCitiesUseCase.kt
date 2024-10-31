package com.baims.dailyforecast.domain.usecases

import com.baims.dailyforecast.domain.ForecastRepository
import com.baims.dailyforecast.domain.model.City
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(
    private val forecastRepository: ForecastRepository,
) {
    suspend operator fun invoke(): List<City> {
        return forecastRepository.getCities()
    }
}