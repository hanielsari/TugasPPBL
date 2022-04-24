package com.example.praktikumtmdb.data.repository.movie.datasourceImpl

import com.example.praktikumtmdb.data.dao.MovieDAO
import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(
    //disini kita menggunakan objek dari dao sebagai parameter
    private val movieDAO: MovieDAO
): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }

    }

}