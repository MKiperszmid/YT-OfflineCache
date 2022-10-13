package com.mk.demoyoutube.data

import com.mk.demoyoutube.DisneyCharacter
import com.mk.demoyoutube.data.local.DisneyDao
import com.mk.demoyoutube.data.mapper.toDomain
import com.mk.demoyoutube.data.mapper.toEntity
import com.mk.demoyoutube.data.remote.DisneyApi

class DisneyRepository(
    private val api: DisneyApi,
    private val dao: DisneyDao
) {
    suspend fun getCharacters(): List<DisneyCharacter> {
        var localCharacters = dao.getCharacters()

        if (localCharacters.isEmpty()) {
            val remoteCharacters = getCharactersRemote()
            remoteCharacters.forEach {
                dao.insertCharacter(it.toEntity())
            }
            localCharacters = dao.getCharacters()
        }
        return localCharacters.map { it.toDomain() }
    }

    private suspend fun getCharactersRemote(): List<DisneyCharacter> {
        return try {
            val characters = api.getCharacters()
            characters.data.mapNotNull { it.toDomain() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
