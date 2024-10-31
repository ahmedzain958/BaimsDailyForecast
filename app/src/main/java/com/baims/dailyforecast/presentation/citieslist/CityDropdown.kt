package com.baims.dailyforecast.presentation.citieslist

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.baims.dailyforecast.domain.model.City
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CityDropdown(viewModel: CitiesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState() // Observe StateFlow as Compose State
    var expanded by remember { mutableStateOf(false) }
    var selectedCity by remember { mutableStateOf<City?>(null) }

    Column {
        // Display the currently selected city name or a prompt to select a city
        Text(
            text = selectedCity?.cityNameEn ?: "Select a city",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp)
        )

        // Dropdown menu for city selection
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            state.citiesList.forEach { city ->
                DropdownMenuItem(text = {
                    Text(text = city.cityNameEn?:"")
                }, onClick = {
                    selectedCity = city
                    expanded = false
                })
            }
        }
    }

}
