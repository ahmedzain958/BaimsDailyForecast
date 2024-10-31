package com.baims.dailyforecast.data.local.model.forecast

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class LocalWeatherData(
    @PrimaryKey
    @ColumnInfo(name = "city_id")
    val id: Int,
    @ColumnInfo(name = "city_name")
    val cityNameEn: String,
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "lon")
    val lon: Double,
    @ColumnInfo(name = "temperature")
    val temperature: Double,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "iconUrl")
    val iconUrl: String? = null,
    @ColumnInfo(name = "dateTime")
    val dateTime: String? = null,
)