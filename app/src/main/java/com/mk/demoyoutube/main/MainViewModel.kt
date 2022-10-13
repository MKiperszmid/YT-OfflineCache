package com.mk.demoyoutube.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.demoyoutube.data.DisneyRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: DisneyRepository
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            val characters = repository.getCharacters()
            state = state.copy(
                characters = characters,
                isLoading = false
            )
        }
    }
}
