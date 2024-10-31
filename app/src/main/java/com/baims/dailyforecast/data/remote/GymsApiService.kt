package com.baims.dailyforecast.data.remote

import com.baims.dailyforecast.data.remote.model.RemoteCity
import com.baims.dailyforecast.data.remote.model.RemoteGym
import retrofit2.http.GET
import retrofit2.http.Query


interface GymsApiService {
    @GET("gyms.json")
    suspend fun getGyms(): List<RemoteGym>

    //https://projectname-5ee14.firebaseio.com/gyms.json?orderBy=%22id%22&equalTo=6
    @GET("gyms.json?orderBy=\"id\"")
    suspend fun getGymById(@Query("equalTo") id: Int): Map<String, RemoteGym>


    @GET("cities.json")
    suspend fun getCities(): List<RemoteCity>


    @GET("cities.json")
    suspend fun getForecast(): List<RemoteCity>


}