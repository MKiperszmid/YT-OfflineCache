package com.mk.demoyoutube.data.mapper

import com.mk.demoyoutube.DisneyCharacter
import com.mk.demoyoutube.data.local.entity.DisneyCharacterEntity
import com.mk.demoyoutube.data.remote.dto.CharacterDataDto

fun CharacterDataDto.toDomain(): DisneyCharacter? {
    val film =
        this.films.firstOrNull() ?: this.shortFilms.firstOrNull() ?: this.tvShows.firstOrNull()
            ?: return null
    return DisneyCharacter(
        name = this.name,
        tvShow = film
    )
}

fun DisneyCharacter.toEntity(): DisneyCharacterEntity {
    return DisneyCharacterEntity(
        name = this.name,
        tvShow = this.tvShow
    )
}

fun DisneyCharacterEntity.toDomain(): DisneyCharacter {
    return DisneyCharacter(
        name = this.name,
        tvShow = this.tvShow
    )
}
