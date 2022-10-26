package com.mk.demoyoutube.data.remote

import com.mk.demoyoutube.data.remote.dto.CharacterResponseDto
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface DisneyApi {
    @GET("characters")
    suspend fun getCharacters(): CharacterResponseDto
}
