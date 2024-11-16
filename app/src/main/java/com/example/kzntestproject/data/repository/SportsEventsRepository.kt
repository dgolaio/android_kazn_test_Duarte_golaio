package com.example.kzntestproject.data.repository

import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.domain.model.SportEvent

interface SportsEventsRepository {
    suspend fun fetchSportsEvents():ApiResponse
}