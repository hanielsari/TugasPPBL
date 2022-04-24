package com.example.praktikumtmdb.domain.usecase

import com.example.praktikumtmdb.data.model.artist.Artist
import com.example.praktikumtmdb.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}