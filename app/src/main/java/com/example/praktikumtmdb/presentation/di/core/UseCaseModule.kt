package com.example.praktikumtmdb.presentation.di.core

import com.example.praktikumtmdb.domain.repository.ArtistRepository
import com.example.praktikumtmdb.domain.repository.MovieRepository
import com.example.praktikumtmdb.domain.repository.TvShowRepository
import com.example.praktikumtmdb.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMovieUseCase {
        return GetMovieUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }
    //Tugas TvShow dan Artist
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository) : GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository) : UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository) : GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository) : UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }
}