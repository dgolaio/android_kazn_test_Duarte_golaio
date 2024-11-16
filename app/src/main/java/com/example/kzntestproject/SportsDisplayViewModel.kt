package com.example.kzntestproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.domain.model.SportEvent
import com.example.kzntestproject.domain.usecase.GetSportEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportsDisplayViewModel @Inject constructor(
    private val getSportEventsUseCase: GetSportEventsUseCase
) : ViewModel() {

    private val _sportsEvents = MutableStateFlow<ApiResponse>(ApiResponse.EventList(emptyList(), ""))
    val sportEvents: StateFlow<ApiResponse> = _sportsEvents

    init {
        loadSportsEvents()
    }

    fun loadSportsEvents() {
        viewModelScope.launch {
            try {
                val events = getSportEventsUseCase.getSportEvents()
                _sportsEvents.value = events
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }
    }
}