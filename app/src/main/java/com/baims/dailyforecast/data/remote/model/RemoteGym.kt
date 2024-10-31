package com.baims.dailyforecast.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteGym(
    val id: Int,
    @SerializedName("gym_name")
    val name: String,
    @SerializedName("gym_location")
    val place: String,
    @SerializedName("is_open")
    val isOpen: Boolean
)