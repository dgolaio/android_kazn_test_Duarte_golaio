package com.example.kzntestproject.domain.usecase

import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.domain.model.SportEvent

interface GetSportEventsUseCase {
    suspend fun getSportEvents() : ApiResponse
}