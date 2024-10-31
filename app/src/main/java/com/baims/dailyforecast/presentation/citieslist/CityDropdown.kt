package com.baims.dailyforecast.presentation.citieslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDropdown(viewModel: CitiesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState() // Observe StateFlow as Compose State
    var expanded by remember { mutableStateOf(false) }
    var selectedCity by remember { mutableStateOf<City?>(null) }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedCity?.cityNameEn ?: "Select a city",
                onValueChange = { },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                state.citiesList.forEach { city ->
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
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewDropDown() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var gender by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }) {
            TextField(
                value = gender,
                onValueChange = {
                    gender = it
                },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = {}) {
                DropdownMenuItem(text = {
                    Text(text = "")
                }, onClick = {
                    gender = ""
                    isExpanded = false
                })
                DropdownMenuItem(text = {
                    Text(text = "Male")
                }, onClick = {
                    gender = "Male"
                    isExpanded = false
                })
                DropdownMenuItem(text = {
                    Text(text = "Female")
                }, onClick = {
                    gender = "Female"
                    isExpanded = false
                })
                DropdownMenuItem(text = {
                    Text(text = "Other")
                }, onClick = {
                    gender = "Other"
                    isExpanded = false
                })
            }
        }
    }
}