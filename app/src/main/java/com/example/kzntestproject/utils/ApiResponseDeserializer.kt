package com.example.kzntestproject.utils

import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.domain.model.EventDetail
import com.example.kzntestproject.domain.model.SportEvent
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

/*Since Json has an irregular format, i had to construct this Deserializer*/
class ApiResponseDeserializer : JsonDeserializer<ApiResponse> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ApiResponse {
        val jsonArray = json.asJsonArray

        val groupedBySportType: MutableMap<String, MutableList<EventDetail>> = mutableMapOf()

        jsonArray.forEach { jsonElement ->
            val jsonObject = jsonElement.asJsonObject

            if (jsonObject.has("id")) {
                val subEventsArray = jsonObject.getAsJsonArray("d")
                subEventsArray?.forEach { subEvent ->
                    processSubEvent(subEvent.asJsonObject, groupedBySportType)
                }
            }
            else if (jsonObject.has("e")) {
                val eventDetailsArray = jsonObject.getAsJsonArray("e")
                eventDetailsArray?.forEach { eventDetail ->
                    val parsedEvent = parseEventDetail(eventDetail.asJsonObject)
                    val sportType = parsedEvent.sportType ?: "Unknown"
                    groupedBySportType.getOrPut(sportType) { mutableListOf() }.add(parsedEvent)
                }
            }
        }

        val eventLists = groupedBySportType.map { (key, events) ->
            ApiResponse.EventList(key, events)
        }

        return ApiResponse.MultipleEventLists(eventLists)
    }

    private fun processSubEvent(
        jsonObject: JsonObject,
        groupedBySportType: MutableMap<String, MutableList<EventDetail>>
    ) {
        val eventDetailsArray = jsonObject.getAsJsonArray("e") ?: return
        eventDetailsArray.forEach { eventDetail ->
            val parsedEvent = parseEventDetail(eventDetail.asJsonObject)
            val sportType = parsedEvent.sportType ?: "Unknown"
            groupedBySportType.getOrPut(sportType) { mutableListOf() }.add(parsedEvent)
        }
    }

    private fun parseEventList(jsonElement: JsonElement): SportEvent {
        val jsonObject = jsonElement.asJsonObject

        val id = jsonObject.get("i")?.asString
        val description = jsonObject.get("d")?.asString

        val eventDetails = jsonObject.getAsJsonArray("e")?.map { parseEventDetail(it) } ?: emptyList()

        return SportEvent(
            id = id,
            description = description,
            eventDetails = eventDetails
        )
    }

    private fun parseEventDetail(jsonElement: JsonElement): EventDetail {
        val eventObject = jsonElement.asJsonObject

        val eventId = eventObject.get("i")?.asString ?: ""
        val eventName = eventObject.get("d")?.asString ?: ""
        val sportCode = eventObject.get("si")?.asString ?: ""
        val shortName = eventObject.get("sh")?.asString ?: ""
        val timestamp = eventObject.get("tt")?.asLong ?: 0L

        return EventDetail(
            id = eventId,
            sportType = sportCode,
            description = eventName,
            timestamp = timestamp,
            shortName = shortName
        )
    }
}
