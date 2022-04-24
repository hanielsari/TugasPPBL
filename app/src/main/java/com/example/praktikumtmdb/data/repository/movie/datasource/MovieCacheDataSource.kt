package com.example.praktikumtmdb.data.repository.movie.datasource

import com.example.praktikumtmdb.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMovieFromCache() : List<Movie>
    suspend fun saveMoviesFromCache(movies : List<Movie>)
}