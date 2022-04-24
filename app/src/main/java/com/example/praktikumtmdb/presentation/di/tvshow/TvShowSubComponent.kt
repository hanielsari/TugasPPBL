package com.example.praktikumtmdb.presentation.di.tvshow

import com.example.praktikumtmdb.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvshowActivity: TvShowActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}