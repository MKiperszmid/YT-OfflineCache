package com.mk.demoyoutube.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mk.demoyoutube.data.local.entity.DisneyCharacterEntity

@Dao
interface DisneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterEntity: DisneyCharacterEntity)

    @Query("SELECT * FROM DisneyCharacterEntity")
    suspend fun getCharacters(): List<DisneyCharacterEntity>
}
