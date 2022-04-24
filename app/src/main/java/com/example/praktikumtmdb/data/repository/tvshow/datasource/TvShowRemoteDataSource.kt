package com.example.praktikumtmdb.data.repository.tvshow.datasource

import com.example.praktikumtmdb.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}