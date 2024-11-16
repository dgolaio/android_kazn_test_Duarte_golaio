package com.example.kzntestproject.data.api

import com.example.kzntestproject.domain.model.EventDetail
import com.example.kzntestproject.domain.model.SportEvent
import com.google.gson.annotations.SerializedName

sealed class ApiResponse {
    data class EventList(val e: List<SportCategory>,val id: String): ApiResponse()
    data class SportCategory(val sportCode: String, val sportName:String,val events: List<SportEvent>)
}