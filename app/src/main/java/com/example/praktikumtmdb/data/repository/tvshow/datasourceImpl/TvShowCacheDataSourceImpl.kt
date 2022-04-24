package com.example.praktikumtmdb.data.repository.tvshow.datasourceImpl

import com.example.praktikumtmdb.data.model.tvshow.TvShow
import com.example.praktikumtmdb.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tv_shows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tv_shows)
    }
}