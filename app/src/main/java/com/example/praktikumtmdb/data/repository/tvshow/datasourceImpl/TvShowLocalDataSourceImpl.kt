package com.example.praktikumtmdb.data.repository.tvshow.datasourceImpl

import com.example.praktikumtmdb.data.dao.ArtistDAO
import com.example.praktikumtmdb.data.dao.TvShowDAO
import com.example.praktikumtmdb.data.model.tvshow.TvShow
import com.example.praktikumtmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(
    private val tvShowDAO: TvShowDAO
) : TvShowLocalDataSource {
    override suspend fun getTvShowsfromDB(): List<TvShow> {
        return tvShowDAO.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tv_shows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShows(tv_shows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShows()
        }
    }
}