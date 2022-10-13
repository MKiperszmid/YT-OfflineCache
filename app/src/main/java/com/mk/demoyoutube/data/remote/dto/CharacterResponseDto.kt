package com.mk.demoyoutube.data.remote.dto


import com.squareup.moshi.Json

data class CharacterResponseDto(
    @Json(name = "count")
    val count: Int,
    @Json(name = "data")
    val `data`: List<CharacterDataDto>,
    @Json(name = "nextPage")
    val nextPage: String,
    @Json(name = "totalPages")
    val totalPages: Int
)