package com.example.praktikumtmdb.data.repository.artist.datasource

import com.example.praktikumtmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists() :Response<ArtistList>
}