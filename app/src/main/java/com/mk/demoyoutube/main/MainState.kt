package com.mk.demoyoutube.main

import com.mk.demoyoutube.DisneyCharacter

data class MainState(
    val characters: List<DisneyCharacter> = emptyList(),
    val isLoading: Boolean = false
)
