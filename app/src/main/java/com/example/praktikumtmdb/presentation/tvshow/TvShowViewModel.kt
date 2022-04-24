package com.example.praktikumtmdb.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.praktikumtmdb.domain.usecase.GetTvShowUseCase
import com.example.praktikumtmdb.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    //memanggil use case apa saja yang bisa dipanggil  di dalam view model ini.
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tv_shows_List = getTvShowUseCase.execute()
        emit(tv_shows_List)
    }

    fun updateTvShows() = liveData {
        val tv_shows_List = updateTvShowUseCase.execute()
        emit(tv_shows_List)
    }
}