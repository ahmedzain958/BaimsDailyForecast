package com.baims.dailyforecast.data.local.model.forecast

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class LocalWeatherData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "city_id")
    val cityId: Int,
    @ColumnInfo(name = "city_name")
    val cityNameEn: String,
    @ColumnInfo(name = "temperature")
    val temperature: Double,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "dateTime")
    val dateTime: String? = null,
)