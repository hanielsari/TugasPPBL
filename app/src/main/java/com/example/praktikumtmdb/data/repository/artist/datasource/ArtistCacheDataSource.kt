package com.example.praktikumtmdb.data.repository.artist.datasource

import com.example.praktikumtmdb.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists : List<Artist>)
}