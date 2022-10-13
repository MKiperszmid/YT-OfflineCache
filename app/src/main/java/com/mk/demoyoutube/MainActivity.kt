package com.mk.demoyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.mk.demoyoutube.data.DisneyRepository
import com.mk.demoyoutube.data.local.DisneyDatabase
import com.mk.demoyoutube.data.remote.DisneyApi
import com.mk.demoyoutube.main.MainScreen
import com.mk.demoyoutube.main.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(this, DisneyDatabase::class.java, "disney_db").build()
        val dao = db.dao
        val repository = DisneyRepository(DisneyApi.instance, dao)
        val viewModel = MainViewModel(repository)
        setContent {
            MainScreen(viewModel = viewModel)
        }
    }
}
