package com.baims.dailyforecast.data.di

import android.content.Context
import androidx.room.Room
import com.baims.dailyforecast.data.GymsRepositoryImpl
import com.baims.dailyforecast.data.local.GymsDao
import com.baims.dailyforecast.data.local.GymsDatabase
import com.baims.dailyforecast.data.remote.GymsApiService
import com.baims.dailyforecast.domain.GymsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GymsDataModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://projectname-5ee14.firebaseio.com/").build()
    }

    @Provides
    @Singleton
    @Named("CitiesRetrofit")
    fun provideCitiesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dev-orcas.s3.eu-west-1.amazonaws.com/uploads/")
            .build()
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): GymsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            GymsDatabase::class.java,
            "gyms_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDao(gymsDatabase: GymsDatabase) = gymsDatabase.dao

    @Provides
    fun provideApiService(retrofit: Retrofit): GymsApiService =
        retrofit.create(GymsApiService::class.java)

    @Provides
    fun provideGymsRepository(
        apiService: GymsApiService,
        gymDao: GymsDao,
        @IODispatcher dispatcher: CoroutineDispatcher,
    ): GymsRepository =
        GymsRepositoryImpl(apiService, gymDao, dispatcher)

}