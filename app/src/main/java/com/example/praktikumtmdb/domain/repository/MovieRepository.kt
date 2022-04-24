package com.example.praktikumtmdb.domain.repository

import com.example.praktikumtmdb.data.model.movie.Movie

interface MovieRepository {
    //kita akan mmebuat dua fungsi untuk mengupdate data movie dan melihat data movie
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies():List<Movie>?
}