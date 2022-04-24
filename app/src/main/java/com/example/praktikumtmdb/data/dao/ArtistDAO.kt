package com.example.praktikumtmdb.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.praktikumtmdb.data.model.artist.Artist
import com.example.praktikumtmdb.data.model.movie.Movie

@Dao
interface ArtistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //menyimpan movie dapat lebih dari satu dengan parameter movies dengan tipe list artist
    suspend fun saveArtists(artists : List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    //mengambil data
    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}