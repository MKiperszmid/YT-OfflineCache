package com.mk.demoyoutube.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DisneyCharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val tvShow: String
)
