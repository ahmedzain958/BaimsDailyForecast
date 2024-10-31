package com.baims.dailyforecast.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "weather")
data class LocalWeatherCityState(
    @ColumnInfo(name = "city_id")
    val id: Int,
    @ColumnInfo(name = "dateTime")
    val dateTime: String? = null,
)
