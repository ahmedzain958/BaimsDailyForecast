package com.baims.dailyforecast.presentation.forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.baims.dailyforecast.R
import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.domain.model.WeatherDataEntity

@Composable
fun ForecastScreen(
    state: ForecastScreenState,
) {
    when {
        state.isLoading -> {
            CircularProgressIndicator()
        }

        state.error != null -> {
            Text(text = "error")
        }

        else -> {
            LazyColumn {
                items(state.weatherDataList) { weatherDataEntity: WeatherDataEntity ->
                    Text(text = weatherDataEntity.temperature.toString())
                }
            }
        }
    }
    Text(text = state.weatherDataList.toString())
}

@Composable
fun CityDropdownMenu(
    cityList: List<City>,
    onCitySelected: (City) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedCity by remember { mutableStateOf<City?>(null) }

    Box(modifier = Modifier.fillMaxWidth()) {
        TextButton(onClick = { expanded = true }) {
            Text(selectedCity?.cityNameEn ?: "Select City")
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "City Dropdown")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            cityList.forEach { city ->
                /*DropdownMenuItem(onClick = {
                    selectedCity = city
                    onCitySelected(city)
                    expanded = false
                }) {
                    Text(text = city.cityNameEn)
                }*/
            }
        }
    }
}

@Composable
fun ErrorContent(
    errorMessage: String,
    cachedWarning: Boolean,
    onRetryClick: () -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = errorMessage, color = Color.Red)
        if (cachedWarning) {
            Text(text = "Displaying cached data", color = Color.Yellow)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onRetryClick) {
            Text("Retry")
        }
    }
}

@Composable
fun WeatherItem(weatherData: WeatherDataEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        /*elevation = 4.dp*/
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = weatherData.description, style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = "Temp: ${weatherData.temperature}°C",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Humidity: ${weatherData.humidity}%",
                    style = MaterialTheme.typography.bodyMedium
                )
                weatherData.dateTime?.let {
                    Text(text = it, style = MaterialTheme.typography.bodySmall)
                }
            }
            weatherData.iconUrl?.let { iconUrl ->
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}
