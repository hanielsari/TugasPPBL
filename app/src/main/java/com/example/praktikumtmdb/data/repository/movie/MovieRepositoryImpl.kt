package com.example.praktikumtmdb.data.repository.movie

import android.util.Log
import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.praktikumtmdb.domain.repository.MovieRepository

class MovieRepositoryImpl(
    //karena kita memanggil semua datasource maka kita harus membuat seluruh parameternya
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies =  getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesFromCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI() :List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies!!
            }

        }catch (e: Exception){
            Log.i("TAG", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB() :List<Movie>{
        lateinit var movieList: List<Movie>
        try {
        movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e: Exception){
            Log.i("TAG", e.message.toString())
        }
        if (movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() :List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMovieFromCache()

        }catch (e: Exception){
            Log.i("TAG", e.message.toString())
        }
        if (movieList.isNotEmpty()){
            return  movieList
        }
        else{
            movieList =getMoviesFromDB()
            movieCacheDataSource.saveMoviesFromCache(movieList)
        }
        return movieList
    }
}