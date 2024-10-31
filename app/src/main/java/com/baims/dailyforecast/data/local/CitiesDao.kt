package com.baims.dailyforecast.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baims.dailyforecast.data.local.model.LocalCity

@Dao
interface CitiesDao {
    @Query("SELECT * FROM cities")
    suspend fun getAll(): List<LocalCity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(cities: List<LocalCity>)
}