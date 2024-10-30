package com.baims.dailyforecast.domain

data class Gym(
    val id: Int,
    val name: String,
    val place: String,
    val isOpen: Boolean,
    val isFavorite: Boolean = false
)
