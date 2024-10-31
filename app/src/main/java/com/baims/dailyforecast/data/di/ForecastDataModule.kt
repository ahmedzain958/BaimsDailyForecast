package com.baims.dailyforecast.data.di

import android.content.Context
import com.baims.dailyforecast.data.ForecastRepositoryImpl
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
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ForecastApiService =
        retrofit.create(ForecastApiService::class.java)

    @Provides
    fun provideForecastRepository(
        @ApplicationContext context: Context,
        apiService: ForecastApiService,
        @IODispatcher dispatcher: CoroutineDispatcher,
    ): ForecastRepository =
        ForecastRepositoryImpl(context, apiService, dispatcher)

}