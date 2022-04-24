package com.example.praktikumtmdb.data.repository.tvshow.datasource

import com.example.praktikumtmdb.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tv_shows : List<TvShow>)
}