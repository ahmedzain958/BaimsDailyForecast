package com.baims.dailyforecast.presentation.gymslist

import com.baims.dailyforecast.domain.Gym

data class GymScreenState(
    val gymsList: List<Gym>,
    val isLoading: Boolean,
    val error: String? = null
)
