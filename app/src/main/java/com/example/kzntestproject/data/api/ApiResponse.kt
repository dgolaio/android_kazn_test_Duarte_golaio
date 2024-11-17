package com.example.kzntestproject.data.api

import com.example.kzntestproject.domain.model.EventDetail
import com.example.kzntestproject.domain.model.SportEvent
import com.google.gson.annotations.SerializedName

//Sealed Class to get Irregular Json format from API
sealed class ApiResponse {
    data class EventList(val key:String , val events: List<EventDetail>?): ApiResponse()
    data class MultipleEventLists(val groupedEvents: List<EventList>) : ApiResponse()
}