package com.baims.dailyforecast.presentation.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baims.dailyforecast.data.remote.ForecastApiService
import com.baims.dailyforecast.domain.model.Gym
import com.baims.dailyforecast.domain.usecases.GetGymsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class GymsDetailsViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val getGymsByIdUseCase: GetGymsByIdUseCase,
) : ViewModel() {
    val state = mutableStateOf<Gym?>(null)
    private var apiService: ForecastApiService

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://projectname-5ee14.firebaseio.com/").build()
        apiService = retrofit.create(ForecastApiService::class.java)
        val gymId = savedStateHandle.get<Int>("gym_id") ?: 0
        getGym(gymId)
    }

    private fun getGym(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val gym: Gym = getGymFromRemoteDB(id)
            withContext(Dispatchers.Main) {
                state.value = gym
            }
        }
    }

    private suspend fun getGymFromRemoteDB(id: Int) = withContext(Dispatchers.IO) {
        getGymsByIdUseCase(id).values.first().let {
            Gym(
                it.id, it.name, it.place, it.isOpen
            )
        }
    }

}