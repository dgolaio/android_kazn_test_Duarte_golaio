package com.example.kzntestproject.domain.usecase.impl

import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.data.repository.SportsEventsRepository
import com.example.kzntestproject.domain.model.SportEvent
import com.example.kzntestproject.domain.usecase.GetSportEventsUseCase
import javax.inject.Inject

class GetSportEventsUseCaseImpl @Inject constructor(
    private val repository: SportsEventsRepository
): GetSportEventsUseCase {

    override suspend fun getSportEvents(): ApiResponse {
        return repository.fetchSportsEvents()
    }

}