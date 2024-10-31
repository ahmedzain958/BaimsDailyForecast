package com.baims.dailyforecast.presentation.forecast

import com.baims.dailyforecast.domain.model.WeatherDataEntity

data class ForecastScreenState(
    var weatherDataList: List<WeatherDataEntity>,
    var isLoading: Boolean = false,
    var error: String? = null
)