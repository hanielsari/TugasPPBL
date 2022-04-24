package com.example.praktikumtmdb.presentation.di.movie

import com.example.praktikumtmdb.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}