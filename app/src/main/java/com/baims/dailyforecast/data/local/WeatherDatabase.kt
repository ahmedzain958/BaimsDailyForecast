package com.baims.dailyforecast.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baims.dailyforecast.data.local.model.forecast.LocalWeatherData

@Database(entities = [LocalWeatherData::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val dao: WeatherDao
}