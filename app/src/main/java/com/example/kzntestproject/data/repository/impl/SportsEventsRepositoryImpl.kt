package com.example.kzntestproject.data.repository.impl

import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.data.api.ApiService
import com.example.kzntestproject.data.repository.SportsEventsRepository
import com.example.kzntestproject.domain.model.SportEvent
import javax.inject.Inject

class SportsEventsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SportsEventsRepository {

    override suspend fun fetchSportsEvents(): ApiResponse {
        return apiService.getSportEvents()
    }

}