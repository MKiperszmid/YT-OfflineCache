package com.mk.demoyoutube.data

import com.mk.demoyoutube.data.local.DisneyDao
import com.mk.demoyoutube.data.remote.DisneyApi

class DisneyRepository(
    private val api: DisneyApi,
    private val dao: DisneyDao
) {
    suspend fun getCharacters() {
    }
}
