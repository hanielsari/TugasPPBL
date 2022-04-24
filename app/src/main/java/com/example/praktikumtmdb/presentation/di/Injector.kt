package com.example.praktikumtmdb.presentation.di

import com.example.praktikumtmdb.presentation.di.artist.ArtistSubComponent
import com.example.praktikumtmdb.presentation.di.movie.MovieSubComponent
import com.example.praktikumtmdb.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    //pada injector kita akan memanggil sub componentnya
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowComponent():TvShowSubComponent
    fun createArtistComponent():ArtistSubComponent
}