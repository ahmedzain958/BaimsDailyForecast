package com.baims.dailyforecast.data.remote.model


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("country")
    val country: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
)