package com.example.praktikumtmdb.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>?,

)