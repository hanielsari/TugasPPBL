package com.example.praktikumtmdb.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.praktikumtmdb.data.model.tvshow.TvShow

@Dao
interface TvShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //menyimpan movie dapat lebih dari satu dengan parameter movies dengan tipe list tvshow
    suspend fun saveTvShows(tv_shows : List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTvShows()

    //mengambil data
    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShows(): List<TvShow>
}