package com.example.praktikumtmdb.data.repository.movie.datasourceImpl

import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    //dibuat secara sederhana dimana hanya menyimpan cachenya dalam bentuk objek
    private var movieList = ArrayList<Movie>()
    override suspend fun getMovieFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesFromCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}