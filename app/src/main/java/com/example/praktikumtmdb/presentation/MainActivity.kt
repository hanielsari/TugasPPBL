package com.example.praktikumtmdb.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.praktikumtmdb.databinding.ActivityMainBinding
import com.example.praktikumtmdb.presentation.artist.ArtistActivity
import com.example.praktikumtmdb.presentation.movie.MovieActivity
import com.example.praktikumtmdb.presentation.tvshow.TvShowActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMovie.setOnClickListener {
            //akan menuju ke activity movie
            val intent = Intent(applicationContext, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.btnTvShow.setOnClickListener {
            //akan menuju ke activity tvShow
            val intent = Intent(applicationContext, TvShowActivity::class.java)
            startActivity(intent)
        }
        binding.btnArtist.setOnClickListener {
            //akan menuju ke activity artist
            val intent = Intent(applicationContext, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}