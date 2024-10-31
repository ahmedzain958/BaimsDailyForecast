package com.baims.dailyforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.baims.dailyforecast.presentation.citieslist.CitiesDropdownScreen
import com.baims.dailyforecast.presentation.citieslist.ForecastViewModel
import com.baims.dailyforecast.presentation.forecast.ForecastScreen
import com.baims.dailyforecast.ui.theme.BaimsDailyForecastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaimsDailyForecastTheme {
                ForecastAroundApp()
            }
        }
    }
}

@Composable
private fun ForecastAroundApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "cities") {
        composable(route = "cities") {
            CitiesDropdownScreen() { city ->
                navController.navigate("forecast?lat=${city.lat}&lon=${city.lon}")
            }
        }
        composable(
            route = "forecast?lat={lat}&lon={lon}",
            arguments = listOf(
                navArgument("lat") { type = NavType.FloatType },
                navArgument("lon") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val lat = backStackEntry.arguments?.getFloat("lat") ?: 0f
            val lon = backStackEntry.arguments?.getFloat("lon") ?: 0f
            val forecastViewModel: ForecastViewModel = hiltViewModel()
            forecastViewModel.getWeatherDataList(lat.toDouble(), lon.toDouble())
            val state = forecastViewModel.weatherDataListState.value
            ForecastScreen(state = state)
        }
    }
}
