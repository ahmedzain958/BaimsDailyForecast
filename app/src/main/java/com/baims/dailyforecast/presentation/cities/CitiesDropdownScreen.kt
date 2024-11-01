package com.baims.dailyforecast.presentation.cities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.baims.dailyforecast.R
import com.baims.dailyforecast.domain.model.City
import com.baims.dailyforecast.presentation.ForecastViewModel
import com.baims.dailyforecast.ui.theme.BlueJC
import com.baims.dailyforecast.ui.theme.DarkBlueJC
import com.baims.dailyforecast.ui.theme.Pink80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitiesDropdownScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
    onCheckWeatherClick: (City) -> Unit,
) {
    val state by viewModel.state.collectAsState()
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
                Text(text = stringResource(R.string.check_weather))
            }
        }
    }

}

