package com.baims.dailyforecast.data.local.model.forecast

data class Forecast(
    val city: ForecastCity?,
    val cnt: Int?,
    val cod: String?,
    val list: List<Item0?>?,
    val message: Int?
)