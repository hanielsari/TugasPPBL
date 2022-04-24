package com.example.praktikumtmdb.data.repository.movie.datasourceImpl

import com.example.praktikumtmdb.data.api.TMDBService
import com.example.praktikumtmdb.data.model.movie.MovieList
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
): MovieRemoteDataSource {
    //untuk bisa memanggil functionnya maka kita membutuhkan objek dari TMDB Service
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)

    }
}