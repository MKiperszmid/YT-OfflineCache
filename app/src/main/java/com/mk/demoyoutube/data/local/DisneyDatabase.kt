package com.mk.demoyoutube.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mk.demoyoutube.data.local.entity.DisneyCharacterEntity

@Database(entities = [DisneyCharacterEntity::class], version = 1)
abstract class DisneyDatabase : RoomDatabase() {
    abstract val dao: DisneyDao
}
