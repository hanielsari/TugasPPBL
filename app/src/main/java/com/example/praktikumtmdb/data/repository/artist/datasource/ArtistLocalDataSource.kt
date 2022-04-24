package com.example.praktikumtmdb.data.repository.artist.datasource

import com.example.praktikumtmdb.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsfromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists : List<Artist>)
    suspend fun clearAll()
}