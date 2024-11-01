package com.baims.dailyforecast.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baims.dailyforecast.data.local.model.forecast.LocalWeatherData

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(localWeatherData: List<LocalWeatherData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(localWeatherData: LocalWeatherData)

    @Query("SELECT * FROM weather WHERE city_id = :cityId")
    suspend fun getWeatherByCity(cityId: Int): List<LocalWeatherData>
}