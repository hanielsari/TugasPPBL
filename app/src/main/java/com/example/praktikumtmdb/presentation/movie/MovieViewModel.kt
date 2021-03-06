package com.example.praktikumtmdb.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.praktikumtmdb.domain.usecase.GetMovieUseCase
import com.example.praktikumtmdb.domain.usecase.UpdateMovieUseCase

class MovieViewModel(
    //memanggil use case apa saja yang bisa dipanggil  di dalam view model ini.
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }
    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}