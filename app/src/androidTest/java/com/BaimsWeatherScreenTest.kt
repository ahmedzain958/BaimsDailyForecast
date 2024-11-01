package com

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.baims.dailyforecast.CitiesDropdownScreen
import com.baims.dailyforecast.presentation.SemanticDescription
import com.baims.dailyforecast.presentation.cities.CitiesScreenState
import com.baims.dailyforecast.presentation.forecast.ForecastScreenState
import com.baims.dailyforecast.ui.theme.BaimsDailyForecastTheme
import org.junit.Rule
import org.junit.Test

class BaimsWeatherScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadingState_isActive() {
        composeTestRule.setContent {
            BaimsDailyForecastTheme {
                CitiesDropdownScreen(
                    citiesState = CitiesScreenState(emptyList(), true, null),
                    forecastScreenState = ForecastScreenState(emptyList(), true, null),
                    onCheckWeatherClick = {})
            }
        }
        composeTestRule.onNodeWithContentDescription(SemanticDescription.Forecast_LIST_LOADING)
            .assertIsDisplayed()
    }
}