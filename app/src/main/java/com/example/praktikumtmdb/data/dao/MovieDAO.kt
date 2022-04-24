package com.example.praktikumtmdb.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.praktikumtmdb.data.model.movie.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //menyimpan movie dapat lebih dari satu dengan parameter movies dengan tipe list movie
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    //mengambil data
    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}