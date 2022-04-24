package com.example.praktikumtmdb.data.repository.tvshow.datasourceImpl

import com.example.praktikumtmdb.data.api.TMDBService
import com.example.praktikumtmdb.data.model.tvshow.TvShowList
import com.example.praktikumtmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
): TvShowRemoteDataSource {
    //untuk bisa memanggil functionnya maka kita membutuhkan objek dari TMDB Service
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}