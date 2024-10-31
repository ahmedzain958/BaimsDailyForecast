package com.baims.dailyforecast.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baims.dailyforecast.data.local.model.LocalGym

@Database(entities = [LocalGym::class], version = 1, exportSchema = false)
abstract class GymsDatabase : RoomDatabase() {
    abstract val dao: GymsDao


}