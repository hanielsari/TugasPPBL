package com.example.praktikumtmdb.domain.repository

import com.example.praktikumtmdb.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}