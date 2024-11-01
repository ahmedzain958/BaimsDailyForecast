package com.baims.dailyforecast.domain.model

import com.baims.dailyforecast.data.remote.model.Weather

data class WeatherEntity(
    val temperature: Double,
    val humidity: Int,
    val dateTime: String,
    val description: String,
    val cityName: String,
)