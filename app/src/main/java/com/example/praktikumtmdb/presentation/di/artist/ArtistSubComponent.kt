package com.example.praktikumtmdb.presentation.di.artist

import com.example.praktikumtmdb.presentation.artist.ArtistActivity
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}