package com.example.kzntestproject.utils

import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.domain.model.EventDetail
import com.example.kzntestproject.domain.model.SportEvent
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ApiResponseDeserializer : JsonDeserializer<ApiResponse>{
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ApiResponse {

        val jsonArray = json.asJsonArray

        val eventList = jsonArray.map {
            jsonElement ->
            parseEventList(jsonElement)
        }

        return ApiResponse.EventList(e = eventList,"i")
    }

    private fun parseEventList(jsonElement: JsonElement): ApiResponse.SportCategory {
        val jsonObject = jsonElement.asJsonObject

        val id = jsonObject.has("id")

        //if has an id
        if (id) {
            val withIdEvents = jsonObject.get("d").asJsonArray

            val gatherSportEvents: ArrayList<SportEvent> = arrayListOf()

            withIdEvents.map { ev ->
                val eachEvent = ev.asJsonObject
                val auxEven = eachEvent.get("e").asJsonArray

                val eventDetails: ArrayList<EventDetail> = arrayListOf()

                auxEven.map {
                   evntDetail ->
                   eventDetails.add(parseEventDetail(evntDetail.asJsonObject))
                }

                gatherSportEvents.add(
                    SportEvent(
                        eachEvent.get("i").asString,
                        eachEvent.get("d").asString,
                        eventDetails
                    )
                )
            }
            return ApiResponse.SportCategory("", "", gatherSportEvents)
        } else { // does not have an id

            val eventsArrayJson = jsonObject.get("e").asJsonArray

            val gatherSportEvents: ArrayList<SportEvent> = arrayListOf()

            val eventDetails: ArrayList<EventDetail> = arrayListOf()

            eventsArrayJson.map {
                event ->
                eventDetails.add(parseEventDetail(event.asJsonObject))
            }

            gatherSportEvents.add(
                SportEvent(
                    jsonObject.get("i").asString,
                    jsonObject.get("d").asString,
                    eventDetails
                )
            )
            return ApiResponse.SportCategory(jsonObject.get("i").asString, jsonObject.get("d").asString, gatherSportEvents)
        }
    }

    private fun parseEventDetail(jsonElement: JsonElement): EventDetail {
        val eventObject = jsonElement.asJsonObject

        val eventId = eventObject.get("i")?.asString ?: ""
        val eventName = eventObject.get("d")?.asString ?: ""
        val sportCode = eventObject.get("si")?.asString ?: ""
        val shortName = eventObject.get("sh")?.asString ?: ""
        val timestamp = eventObject.get("tt")?.asLong ?: 0L

        return EventDetail(eventId, eventName, sportCode,timestamp,shortName)
    }

    
}
