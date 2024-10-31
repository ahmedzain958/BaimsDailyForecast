package com.baims.dailyforecast.presentation.forecast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.baims.dailyforecast.presentation.citieslist.ForecastViewModel

@Composable
fun ForecastScreen(){
    val forecastViewModel: ForecastViewModel = hiltViewModel()


}