package com.baims.dailyforecast.data.remote.model


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("temp")
    val temp: Double?
)