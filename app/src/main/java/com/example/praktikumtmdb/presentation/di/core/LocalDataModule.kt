package com.example.praktikumtmdb.presentation.di.core

import com.example.praktikumtmdb.data.dao.ArtistDAO
import com.example.praktikumtmdb.data.dao.MovieDAO
import com.example.praktikumtmdb.data.dao.TvShowDAO
import com.example.praktikumtmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.praktikumtmdb.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.example.praktikumtmdb.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.praktikumtmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.praktikumtmdb.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDAO)
    }
}