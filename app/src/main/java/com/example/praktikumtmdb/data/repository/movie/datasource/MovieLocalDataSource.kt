package com.example.praktikumtmdb.data.repository.movie.datasource

import com.example.praktikumtmdb.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()

}