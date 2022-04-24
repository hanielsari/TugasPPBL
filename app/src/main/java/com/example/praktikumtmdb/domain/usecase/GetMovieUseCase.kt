package com.example.praktikumtmdb.domain.usecase

import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository : MovieRepository) {
    //private val movieRepository :MovieRepository merupakan proses depedency injection yang akan dilakukan
    //oleh dagger
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}