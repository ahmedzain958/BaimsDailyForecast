package com.baims.dailyforecast.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.baims.dailyforecast.data.local.model.forecast.LocalWeatherData

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather")
    suspend fun getAll(): List<LocalWeatherData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(localWeatherData: List<LocalWeatherData>)

    @Query("SELECT * FROM weather WHERE city_id = 1")
    suspend fun getWeatherByCity(): List<LocalWeatherData>

    @Update(entity = LocalWeatherData::class)
    suspend fun updateAll(localGymFavouriteStates: List<LocalWeatherCityState>)
}