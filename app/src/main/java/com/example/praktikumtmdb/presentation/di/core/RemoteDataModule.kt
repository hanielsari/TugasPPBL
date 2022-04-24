package com.example.praktikumtmdb.presentation.di.core

import com.example.praktikumtmdb.data.api.TMDBService
import com.example.praktikumtmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.praktikumtmdb.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.praktikumtmdb.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.praktikumtmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.praktikumtmdb.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//pada kelas ini akan memprovide semua data yang remote
@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}
