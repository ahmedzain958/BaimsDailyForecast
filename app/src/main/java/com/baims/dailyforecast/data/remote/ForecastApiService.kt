package com.baims.dailyforecast.data.remote

import com.baims.dailyforecast.data.remote.model.RemoteCity
import com.baims.dailyforecast.data.remote.model.RemoteGym
import com.baims.dailyforecast.data.remote.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ForecastApiService {
    @GET("gyms.json")
    suspend fun getGyms(): List<RemoteGym>

    //https://projectname-5ee14.firebaseio.com/gyms.json?orderBy=%22id%22&equalTo=6
    @GET("gyms.json?orderBy=\"id\"")
    suspend fun getGymById(@Query("equalTo") id: Int): Map<String, RemoteGym>

    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ): WeatherResponse
}