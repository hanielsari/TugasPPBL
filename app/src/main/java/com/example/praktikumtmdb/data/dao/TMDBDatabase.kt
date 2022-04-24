package com.example.praktikumtmdb.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.praktikumtmdb.data.model.artist.Artist
import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    //selanjutnya kita buat tiga buah abstract function
    abstract fun movieDao(): MovieDAO
    abstract fun tvShowDao(): TvShowDAO
    abstract fun artistDao(): ArtistDAO

}