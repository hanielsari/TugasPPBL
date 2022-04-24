package com.example.praktikumtmdb.data.api

import com.example.praktikumtmdb.data.model.artist.ArtistList
import com.example.praktikumtmdb.data.model.movie.MovieList
import com.example.praktikumtmdb.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    //karena kita menjalankan dicoroutine kita membuat suspend function
    suspend fun getPopularMovies(@Query("api_key") apiKey :String) :Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey :String) :Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apiKey :String) :Response<ArtistList>

}