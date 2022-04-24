package com.example.praktikumtmdb.presentation.di.artist

import com.example.praktikumtmdb.domain.usecase.GetArtistUseCase
import com.example.praktikumtmdb.domain.usecase.UpdateArtistUseCase
import com.example.praktikumtmdb.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    //Sebelumnya kita sudah membuat View Model Factorynya
    @ArtistScope
    @Provides
    fun provideMovieViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}