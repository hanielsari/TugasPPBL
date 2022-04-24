package com.example.praktikumtmdb.presentation.di.movie

import com.example.praktikumtmdb.domain.usecase.GetMovieUseCase
import com.example.praktikumtmdb.domain.usecase.UpdateMovieUseCase
import com.example.praktikumtmdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    //Sebelumnya kita sudah membuat View Model Factorynya
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(
            getMovieUseCase,updateMovieUseCase)
    }
}