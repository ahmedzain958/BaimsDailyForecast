package com.baims.dailyforecast.domain.model

data class WeatherDataEntity(
    val temperature: Double,
    val humidity: Int,
    val description: String,
    val iconUrl: String? = null,
    val dateTime: String? = null,
)