package com.baims.dailyforecast.presentation.forecast

import com.baims.dailyforecast.domain.model.WeatherEntity

data class ForecastScreenState(
    var weatherDataList: List<WeatherEntity>,
    var isLoading: Boolean = false,
    var error: String? = null
)