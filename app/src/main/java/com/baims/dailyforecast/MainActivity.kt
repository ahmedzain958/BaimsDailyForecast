package com.baims.dailyforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.domain.model.WeatherEntity
import com.baims.dailyforecast.presentation.ForecastViewModel
import com.baims.dailyforecast.presentation.cities.CitiesScreenState
import com.baims.dailyforecast.presentation.forecast.ForecastScreenState
import com.baims.dailyforecast.ui.theme.BaimsDailyForecastTheme
import com.baims.dailyforecast.ui.theme.BlueJC
import com.baims.dailyforecast.ui.theme.DarkBlueJC
import com.baims.dailyforecast.ui.theme.Pink80
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaimsDailyForecastTheme {
                val viewModel: ForecastViewModel = hiltViewModel()
                CitiesDropdownScreen(
                    viewModel.citiesState.collectAsState().value,
                    viewModel.weatherDataListState.collectAsState().value
                ) { city: City ->
                    viewModel.getWeatherDataList(
                        city.id ?: 0,
                        city.cityNameEn ?: "",
                        city.lat ?: 0.0,
                        city.lon ?: 0.0
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitiesDropdownScreen(
    citiesState: CitiesScreenState,
    forecastScreenState: ForecastScreenState,
    onCheckWeatherClick: (City) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedCity by remember { mutableStateOf<City?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.sun),
                contentScale = ContentScale.FillBounds,
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(30.dp))
            ) {
                TextField(
                    value = selectedCity?.cityNameEn ?: stringResource(R.string.select_a_city),
                    shape = RoundedCornerShape(30.dp),
                    onValueChange = { },
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedIndicatorColor = BlueJC,
                        focusedIndicatorColor = BlueJC,
                        focusedLabelColor = DarkBlueJC,
                    ),
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    citiesState.citiesList.forEach { city ->
                        DropdownMenuItem(
                            text = {
                                Text(text = city.cityNameEn ?: "")
                            },
                            onClick = {
                                selectedCity = city
                                expanded = false
                            }
                        )
                    }
                }
            }
            Button(
                onClick = {
                    selectedCity?.let { city ->
                        onCheckWeatherClick.invoke(city)
                    }
                },
                colors = ButtonDefaults.buttonColors(Pink80),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                enabled = selectedCity != null
            ) {
                Text(
                    text = stringResource(R.string.check_weather),
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            WeatherList(forecastScreenState)
        }
    }
}

@Composable
fun WeatherList(forecastScreenState: ForecastScreenState) {
    if (!forecastScreenState.isLoading
        && forecastScreenState.weatherDataList.isNotEmpty()
    ) {
        val weatherList = forecastScreenState.weatherDataList
        LazyColumn {
            items(weatherList) {
                DailyItem(weatherEntity = it)
            }
        }
    }
}

@Composable
fun WeatherCard(
    label: String,
    value: String,
    icon: ImageVector,
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = DarkBlueJC,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = label,
                    fontSize = 14.sp,
                    color = DarkBlueJC,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value,
                    fontSize = 22.sp,
                    color = BlueJC,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun DailyItem(weatherEntity: WeatherEntity) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        WeatherCard(label = "city", value = weatherEntity.cityName, icon = Icons.Default.Place)
        WeatherCard(
            label = "temperature",
            value = "${weatherEntity.temperature}°C",
            icon = Icons.Default.Star
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        WeatherCard(
            label = "humidity",
            value = "${weatherEntity.humidity}%",
            icon = Icons.Default.Warning
        )
        WeatherCard(
            label = "description",
            value = weatherEntity.description,
            icon = Icons.Default.Info
        )
    }
    Spacer(modifier = Modifier.height(32.dp))
}
