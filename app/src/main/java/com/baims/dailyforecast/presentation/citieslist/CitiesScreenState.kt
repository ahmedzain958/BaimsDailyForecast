package com.baims.dailyforecast.presentation.citieslist

import com.baims.dailyforecast.domain.model.City

data class CitiesScreenState(
    var citiesList: List<City>,
    var isLoading: Boolean = true,
    var error: String? = null
)