package com.baims.dailyforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.baims.dailyforecast.presentation.citieslist.CitiesViewModel
import com.baims.dailyforecast.presentation.citieslist.CityDropdown
import com.baims.dailyforecast.presentation.details.GymDetailsScreen
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
                GymsAroundApp()
            }
        }
    }
}

@Composable
private fun GymsAroundApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "gyms") {
        composable(route = "gyms") {
            val gymsViewModel: GymsViewModel = hiltViewModel()
            val citiesViewModel: CitiesViewModel = hiltViewModel()
            Column {
                CityDropdown(citiesViewModel)
                GymsScreen(gymsViewModel.state.value, { id ->
                    navController.navigate("gyms/$id")
                }, onFavouriteIconClick = { id: Int, oldValue: Boolean ->
                    gymsViewModel.toggleFavState(id, oldValue)
                })
            }

        }

        composable(
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
        }
    }
}
