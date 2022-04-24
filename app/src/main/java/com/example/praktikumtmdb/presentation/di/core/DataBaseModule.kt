package com.example.praktikumtmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.praktikumtmdb.data.dao.ArtistDAO
import com.example.praktikumtmdb.data.dao.MovieDAO
import com.example.praktikumtmdb.data.dao.TMDBDatabase
import com.example.praktikumtmdb.data.dao.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    //disini di buat agar dapat melakukan movie database
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    //sekarang untuk melakukan provide semua functionnya
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDAO {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDAO {
        return tmdbDatabase.artistDao()
    }

}