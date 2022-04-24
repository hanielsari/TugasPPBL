package com.example.praktikumtmdb.domain.usecase

import com.example.praktikumtmdb.data.model.tvshow.TvShow
import com.example.praktikumtmdb.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}
