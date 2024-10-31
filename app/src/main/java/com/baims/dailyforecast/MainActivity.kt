package com.baims.dailyforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baims.dailyforecast.presentation.citieslist.ForecastViewModel
import com.baims.dailyforecast.presentation.citieslist.CityDropdown
import com.baims.dailyforecast.presentation.gymslist.GymsScreen
import com.baims.dailyforecast.presentation.gymslist.GymsViewModel
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
    NavHost(navController = navController, startDestination = "gyms") {
        composable(route = "gyms") {
            val gymsViewModel: GymsViewModel = hiltViewModel()
            val forecastViewModel: ForecastViewModel = hiltViewModel()
            Column {
                CityDropdown(forecastViewModel, {})
                GymsScreen(gymsViewModel.state.value, { id ->
                    navController.navigate("gyms/$id")
                }, onFavouriteIconClick = { id: Int, oldValue: Boolean ->
                    gymsViewModel.toggleFavState(id, oldValue)
                })
            }

        }

       /* composable(
            route = "gyms/{gym_id}", arguments = listOf(
                navArgument("gym_id") {
                    type = NavType.IntType
                }), deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://www.gymsaround.com/details/{gym_id}"

                }
            )
        ) { it: androidx.navigation.NavBackStackEntry ->
            GymDetailsScreen()
        }*/
    }
}
