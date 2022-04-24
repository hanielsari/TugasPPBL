package com.example.praktikumtmdb.data.repository.artist.datasourceImpl

import com.example.praktikumtmdb.data.dao.ArtistDAO
import com.example.praktikumtmdb.data.dao.MovieDAO
import com.example.praktikumtmdb.data.model.artist.Artist
import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.praktikumtmdb.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDAO: ArtistDAO
) : ArtistLocalDataSource {
    override suspend fun getArtistsfromDB(): List<Artist> {
        return artistDAO.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtists()
        }
    }
}
