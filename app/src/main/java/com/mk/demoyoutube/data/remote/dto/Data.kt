package com.mk.demoyoutube.data.remote.dto


import com.squareup.moshi.Json

data class Data(
    @Json(name = "allies")
    val allies: List<Any>,
    @Json(name = "enemies")
    val enemies: List<Any>,
    @Json(name = "films")
    val films: List<String>,
    @Json(name = "_id")
    val id: Int,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "parkAttractions")
    val parkAttractions: List<String>,
    @Json(name = "shortFilms")
    val shortFilms: List<String>,
    @Json(name = "tvShows")
    val tvShows: List<String>,
    @Json(name = "url")
    val url: String,
    @Json(name = "videoGames")
    val videoGames: List<String>
)