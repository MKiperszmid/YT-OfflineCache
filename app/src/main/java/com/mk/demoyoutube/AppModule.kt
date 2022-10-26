package com.mk.demoyoutube

import android.app.Application
import androidx.room.Room
import com.mk.demoyoutube.data.DisneyRepository
import com.mk.demoyoutube.data.local.DisneyDao
import com.mk.demoyoutube.data.local.DisneyDatabase
import com.mk.demoyoutube.data.remote.DisneyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDisneyApi(): DisneyApi {
        return Retrofit.Builder().baseUrl("https://api.disneyapi.dev/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build()).build().create(DisneyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDisneyDao(application: Application): DisneyDao {
        val db = Room.databaseBuilder(
            application,
            DisneyDatabase::class.java,
            "disney_db"
        ).build()
        return db.dao
    }

    @Provides
    @Singleton
    fun provideRepository(api: DisneyApi, dao: DisneyDao): DisneyRepository {
        return DisneyRepository(
            api,
            dao
        )
    }

    @Provides
    @Singleton
    fun provideGetCharacter(repository: DisneyRepository): GetCharacters {
        return GetCharacters(repository)
    }
}
