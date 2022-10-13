package com.mk.demoyoutube.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mk.demoyoutube.data.DisneyRepository

class MainViewModel(
    private val repository: DisneyRepository
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
    }
}
