package com.baims.dailyforecast.presentation.citieslist

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baims.dailyforecast.data.di.IODispatcher
import com.baims.dailyforecast.domain.usecases.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase,
    @IODispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _state = MutableStateFlow(CitiesScreenState(emptyList(), true)) // Use MutableStateFlow
    val state: StateFlow<CitiesScreenState> = _state.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        _state.value = _state.value.copy(error = throwable.message, isLoading = false)
    }

    init {
        loadCities()
    }

    private fun loadCities() {
        viewModelScope.launch(coroutineExceptionHandler + dispatcher) {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val cities = getCitiesUseCase()
                _state.value = _state.value.copy(citiesList = cities, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message, isLoading = false)
            }
        }
    }
}