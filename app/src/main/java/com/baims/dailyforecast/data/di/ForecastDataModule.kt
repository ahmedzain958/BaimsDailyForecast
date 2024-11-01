package com.baims.dailyforecast.data.di

import android.content.Context
import androidx.room.Room
import com.baims.dailyforecast.data.ForecastRepositoryImpl
import com.baims.dailyforecast.data.local.WeatherDao
import com.baims.dailyforecast.data.local.WeatherDatabase
import com.baims.dailyforecast.data.remote.ForecastApiService
import com.baims.dailyforecast.domain.ForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ForecastDataModule {

    @Provides
    @Singleton
    fun provideCitiesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java,
            Constants.WEATHER_DATABASE
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDao(weatherDatabase: WeatherDatabase) = weatherDatabase.dao


    @Provides
    fun provideApiService(retrofit: Retrofit): ForecastApiService =
        retrofit.create(ForecastApiService::class.java)

    @Provides
    fun provideForecastRepository(
        @ApplicationContext context: Context,
        apiService: ForecastApiService,
        weatherDao: WeatherDao,
        @IODispatcher dispatcher: CoroutineDispatcher,
    ): ForecastRepository =
        ForecastRepositoryImpl(context, apiService, weatherDao, dispatcher)

}

object Constants {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val WEATHER_DATABASE = "weather_database"
}