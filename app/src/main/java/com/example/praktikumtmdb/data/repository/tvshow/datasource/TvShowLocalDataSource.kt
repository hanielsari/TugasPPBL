package com.example.praktikumtmdb.data.repository.tvshow.datasource

import com.example.praktikumtmdb.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsfromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tv_shows : List<TvShow>)
    suspend fun clearAll()

}