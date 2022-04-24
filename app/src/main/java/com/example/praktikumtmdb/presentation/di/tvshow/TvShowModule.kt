package com.example.praktikumtmdb.presentation.di.tvshow

import com.example.praktikumtmdb.domain.usecase.GetTvShowUseCase
import com.example.praktikumtmdb.domain.usecase.UpdateTvShowUseCase
import com.example.praktikumtmdb.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    //Sebelumnya kita sudah membuat View Model Factorynya
    @TvShowScope
    @Provides
    fun provideMovieViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }
}