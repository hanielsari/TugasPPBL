package com.example.praktikumtmdb.domain.usecase

import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository : MovieRepository) {
    //private val movieRepository :MovieRepository merupakan proses depedency injection yang akan dilakukan
    //oleh dagger
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}