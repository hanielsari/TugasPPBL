package com.example.praktikumtmdb.data.repository.movie.datasource

import com.example.praktikumtmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}