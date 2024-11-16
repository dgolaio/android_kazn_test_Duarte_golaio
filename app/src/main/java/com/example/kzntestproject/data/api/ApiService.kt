package com.example.kzntestproject.data.api

import com.example.kzntestproject.domain.model.SportEvent
import retrofit2.http.GET

interface ApiService {
    @GET("sports/")
    suspend fun getSportEvents(): ApiResponse

    @GET("sports/")
    suspend fun getSportEventsAny(): List<Any>
}