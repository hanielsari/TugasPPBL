package com.example.praktikumtmdb.presentation.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikumtmdb.R
import com.example.praktikumtmdb.databinding.ActivityTvShowBinding
import com.example.praktikumtmdb.presentation.di.Injector
import com.example.praktikumtmdb.presentation.movie.MovieAdapter
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createTvShowComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)
//        viewModel.getMovies().observe(this, Observer { movies ->
//            Log.i("TAG", movies.toString())
//        })
        initRecycleView()

    }

    fun initRecycleView() {
        binding.rvTvShows.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.rvTvShows.adapter = adapter
        displayPopularMovies()
    }

    fun displayPopularMovies() {
        binding.pbTvShows.visibility = View.VISIBLE
        val response = viewModel.getTvShows()
        response.observe(this, Observer { tvshows ->
            if (tvshows != null) {
                adapter.setList(tvshows)
            } else {
                Toast.makeText(this, "Data Tidak Ada", Toast.LENGTH_SHORT).show()
            }
            binding.pbTvShows.visibility = View.GONE

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_update, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update->{
                updateTvShows()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows(){
        binding.pbTvShows.visibility = View.VISIBLE
        val response = viewModel.updateTvShows()
        response.observe(this, Observer {tvshows->
            if(tvshows!=null){
                adapter.setList(tvshows)
            }else{
                Toast.makeText(this,"Data Tidak Ada", Toast.LENGTH_LONG).show()
            }
            binding.pbTvShows.visibility = View.GONE

        })
    }
}
