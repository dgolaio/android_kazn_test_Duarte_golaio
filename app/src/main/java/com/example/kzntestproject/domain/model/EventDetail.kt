package com.example.kzntestproject.domain.model

import com.google.gson.annotations.SerializedName

data class EventDetail(
    @SerializedName("i") val id: String? = null,
    @SerializedName("si") val sportType: String? = null,
    @SerializedName("d") val description: String? = null,
    @SerializedName("tt") val timestamp: Long?= null,
    @SerializedName("sh") val shortName: String?= null
)
