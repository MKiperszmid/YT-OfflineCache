package com.mk.demoyoutube

import com.mk.demoyoutube.data.DisneyRepository

class GetCharacters(
    private val repository: DisneyRepository
) {
    suspend fun getCharacters(): List<DisneyCharacter> {
        return repository.getCharacters()
    }
}
