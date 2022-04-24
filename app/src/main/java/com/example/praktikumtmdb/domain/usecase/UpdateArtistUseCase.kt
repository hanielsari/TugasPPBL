package com.example.praktikumtmdb.domain.usecase

import com.example.praktikumtmdb.data.model.artist.Artist
import com.example.praktikumtmdb.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}