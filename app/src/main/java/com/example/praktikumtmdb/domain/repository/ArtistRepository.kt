package com.example.praktikumtmdb.domain.repository

import com.example.praktikumtmdb.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists():List<Artist>?
}