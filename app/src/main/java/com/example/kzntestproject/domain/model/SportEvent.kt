package com.example.kzntestproject.domain.model

import com.google.gson.annotations.SerializedName


data class SportEvent(
    @SerializedName("i") val id: String? = null,
    @SerializedName("d") val description: String? = null,
    @SerializedName("e") val eventDetails: List<EventDetail>? = emptyList()
)